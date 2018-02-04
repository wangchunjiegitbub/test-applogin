package com.sc.dmh.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.sc.dmh.annotation.AuthPassport;
import com.sc.dmh.beans.AppUser;
import com.sc.dmh.beans.Place;
import com.sc.dmh.beans.PlaceExample;
import com.sc.dmh.beans.PlaceExample.Criteria;
import com.sc.dmh.beans.Sign;
import com.sc.dmh.beans.SignExample;
import com.sc.dmh.service.inter.PlaceServiceI;
import com.sc.dmh.service.inter.SignServiceI;
import com.sc.dmh.service.inter.SignViewServiceI;
import com.sc.dmh.util.GCJ02_BD09;
import com.sc.dmh.util.GCJ02_BD09.Gps;




@Controller
//@RequestMapping("/userController")
public class PositionController {
	private static final Logger logger = Logger.getLogger(PositionController.class);
	@Autowired
	private PlaceServiceI placeService;
	
	@Autowired
	private SignServiceI signService;
	
	@Autowired
	private SignViewServiceI signViewService;

		public void setPlaceService(PlaceServiceI placeService) {
		this.placeService = placeService;
	}

	public void setSignService(SignServiceI signService) {
		this.signService = signService;
	}

	public void setSignViewService(SignViewServiceI signViewService) {
		this.signViewService = signViewService;
	}


		//自定义权限验证注解加注解时表示有权限是才能访问
		@AuthPassport
		//登陆控制器
		@RequestMapping("/getCurrentPosition")
		public void getCurrentPosition(String data,
				HttpServletRequest request, 
				HttpServletResponse resp) 
				throws IOException {//@PathVariable String id(路径变量如@RequestMapping("/{id}/showUser"))
			
			resp.setContentType("text/html;charset=utf-8");	
			//得到用户
			AppUser userSession = (AppUser) request.getSession().getAttribute("sessionUser");
			
			String json = "";
			
			
			
			if(null == data){
				logger.info("isempty");
				return;
			}
			
			
			ObjectMapper mapper = new ObjectMapper();  
			Place place = mapper.readValue(data, Place.class);
			
			//坐标系统转换
			Gps bdGps = GCJ02_BD09.gcj02_To_Bd09(place.getLongitude().doubleValue(), place.getLatitude().doubleValue());
			
			place.setLatitude(new BigDecimal(bdGps.lat + ""));
			place.setLongitude(new BigDecimal(bdGps.lon + ""));
			
			
			//设置查询条件为两点间的数据
			PlaceExample example = new PlaceExample();
			Criteria c = example.createCriteria();
			c.andLatitudeWestLessThanOrEqualTo(place.getLatitude());
			c.andLatitudeEastGreaterThanOrEqualTo(place.getLatitude());
			c.andLongitudeWestLessThanOrEqualTo(place.getLongitude());
			c.andLongitudeEastGreaterThanOrEqualTo(place.getLongitude());
			
			List<Place> placeList = placeService.selectByExample(example);
			
			//无地点数据不能签到
			if( null == placeList || placeList.isEmpty()){
				
				json = "{\"result\":\"-1\",\"message\":\"您的位置未在车站不能签到！\"}";
				
				resp.getWriter().write(json);
				return;
			}
			//地点有正确数据
			if( !placeList.isEmpty() && placeList.size()>0 ){
				SignExample exampleSign = new SignExample();
				com.sc.dmh.beans.SignExample.Criteria cSign = exampleSign.createCriteria();
				//设置查询条件为当前用户ID及当前地点ID
				cSign.andUserIdEqualTo(userSession.getId());
				cSign.andPlaceIdEqualTo(placeList.get(0).getId());
				
				//设置排序规则降序排列查询当前用户在当前地点签到记录
				exampleSign.setOrderByClause("sign_intime desc");
				List<Sign> signList = signService.selectByExample(exampleSign);
				
				//地点签到表查询无数据添加数据或者有数据并且状态为正常签离
				if(null == signList || signList.isEmpty() || (!signList.isEmpty() && signList.size()>0 && signList.get(0).getSignState()==1)){
				
					//签到及处理未签离问题
					json = signIn(userSession, place, placeList, 0);
					
					
					
				//签到表查询到有效数据并且状态为0	-未签离
				}else if( !signList.isEmpty() && signList.size()>0 && signList.get(0).getSignState()==0){
					
					//签离
					json = signOut(userSession, place, placeList, 1);
					
					
				}
			
			}
			// {"total":10 , "rows":[{},{}]}
			
			
			resp.getWriter().write(json);
		}

		/**
		 * @param userSession
		 * @param placeList
		 * @param exampleSign
		 */
		private String signNoOut(AppUser userSession, List<Place> placeList) {
			SignExample exampleSign = new SignExample();
			com.sc.dmh.beans.SignExample.Criteria cSign2 = exampleSign.createCriteria();
			cSign2.andUserIdEqualTo(userSession.getId());
			cSign2.andPlaceIdNotEqualTo(placeList.get(0).getId());
			cSign2.andSignStateEqualTo(0);
			List<Sign> signNoOutList = signService.selectByExample(exampleSign);
			//没有未签离记录退出
			if(null == signNoOutList || signNoOutList.isEmpty()){
				return "";
			}else{
				signNoOutList.get(0).setSignState(2);
				logger.debug(JSON.toJSONString(signNoOutList.get(0)));
				logger.debug(JSON.toJSONString(exampleSign));
				signService.updateByPrimaryKey(signNoOutList.get(0));
				return signNoOutList.get(0).getPlaceId().toString();
			}
		}

		

		/**
		 * @param userSession
		 * @param place
		 * @param placeList
		 * @return
		 */
		private String signIn(AppUser userSession, Place place, List<Place> placeList, Integer state) {
			String json;
			Sign record = new Sign();
			record.setPlaceId(placeList.get(0).getId());
			record.setSignInlatitude(place.getLatitude());
			record.setSignInlongitude(place.getLongitude());
			record.setUserId(userSession.getId());
			record.setSignIntime(new Date());
			record.setSignState(state);
			int i = signService.insert(record);
			
			//处理其他地点未签离问题
			String s = signNoOut(userSession, placeList);
			if("".equals(s)){
				json = "{\"result\":\"1\",\"message\":\"" + placeList.get(0).getPlaceName() + "签到成功！\"}";
			}else{
				json = "{\"result\":\"1\",\"message\":\"" + placeList.get(0).getPlaceName() + "签到成功！上一站已经按照未签离处理！\"}";
			}
			
			
			return json;
		}
	
		/**
		 * @param userSession
		 * @param place
		 * @param placeList
		 * @return
		 */
		private String signOut(AppUser userSession, Place place, List<Place> placeList, Integer state) {
			
			SignExample exampleSign = new SignExample();
			com.sc.dmh.beans.SignExample.Criteria cSign = exampleSign.createCriteria();
			//设置查询条件为当前用户ID及当前地点ID
			cSign.andUserIdEqualTo(userSession.getId());
			cSign.andPlaceIdEqualTo(placeList.get(0).getId());
			cSign.andSignStateEqualTo(0);
			
			String json = "";
			Sign record = new Sign();
			
			record.setSignOutlatitude(place.getLatitude());
			record.setSignOutlongitude(place.getLongitude());
			
			record.setSignOuttime(new Date());
			record.setSignState(state);
			
			int i = signService.updateByExampleSelective(record, exampleSign);
			json = "{\"result\":\"1\",\"message\":\"" + placeList.get(0).getPlaceName() + "签离成功！\"}";
			return json;
		}
	
	
	


				
				
				/**
				   * 字符串转解密
				   * @param value
				   * @return
				   */
				  public static String stringToString(String value)  
				  {  
					  char[] chrCharArray; //创建一个字符数组chrCharArray
				      chrCharArray = value.toCharArray(); //将字符串变量转换为字符数组
//				      value= String.valueOf(chrCharArray ); //将字符数组转换为字符串
				      
				      
				      for(int i = 0;i<chrCharArray.length;i++){
				    	 
				    	  System.out.println((int)chrCharArray[i]);	 
				    	  chrCharArray[i] = (char)(chrCharArray[i]+(i+1));
				    	  System.out.println((int)chrCharArray[i]);
				     }
				      value= String.valueOf(chrCharArray ); //将字符数组转换为字符串
				     System.out.println(value);
				      return value;  

				}
				
				/**
				 * form表单提交 Date类型数据绑定 <功能详细描述>
				 * 
				 * @param binder
				 * @see [类、类#方法、类#成员]
				 */
				@InitBinder
				public void initBinder(WebDataBinder binder) {
					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"yyyy-MM-dd");
					dateFormat.setLenient(false);
					
					
					binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
					
//					SimpleDateFormat dateFormat = new SimpleDateFormat(
//							"yyyy-MM-dd HH:mm");
//					dateFormat.setLenient(false);
//					
//					
//					binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
					
				}
	
	
}
