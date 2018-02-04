package com.sc.dmh.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.sc.dmh.beans.SignView;
import com.sc.dmh.beans.SignViewExample;
import com.sc.dmh.service.inter.PlaceServiceI;
import com.sc.dmh.service.inter.SignServiceI;
import com.sc.dmh.service.inter.SignViewServiceI;




@Controller
//@RequestMapping("/userController")
public class SignController {
	private static final Logger logger = Logger.getLogger(SignController.class);
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
//		@AuthPassport
		//登陆控制器
		@RequestMapping("/getSignView")
		public void getSignView(String column,String lastId,String minId,
				HttpServletRequest request, 
				HttpServletResponse resp) 
				throws IOException {//@PathVariable String id(路径变量如@RequestMapping("/{id}/showUser"))
			
			resp.setContentType("text/html;charset=utf-8");	
			//得到用户
//			AppUser userSession = (AppUser) request.getSession().getAttribute("sessionUser");
			logger.debug(column + "   _");
			logger.debug(lastId + "   _");
			logger.debug(minId + "   _");
			List<SignView> signViewList = new ArrayList<SignView>();
			SignViewExample example = new SignViewExample();
			String orderBy = "";
			if(null ==lastId && null == minId){
				logger.debug("第一请求");
				
				example.setOrderByClause("id desc limit 10");
				signViewList = signViewService.selectByExample(example);
			}else if(null == minId){
				logger.debug("下拉加载最新");
				example.clear();
				com.sc.dmh.beans.SignViewExample.Criteria c = example.createCriteria();
				c.andIdBetween(Integer.valueOf(lastId)+1,Integer.valueOf(lastId)+5 );
				orderBy = "id desc";
				logger.debug(orderBy);
				example.setOrderByClause(orderBy);
				signViewList = signViewService.selectByExample(example);
			}else if (null ==lastId){
				logger.debug("上拉加载更多");
				example.clear();
				com.sc.dmh.beans.SignViewExample.Criteria c = example.createCriteria();
				c.andIdBetween(Integer.valueOf(minId)-5,Integer.valueOf(minId)-1 );
				orderBy = "id desc";
				logger.debug(orderBy);
				example.setOrderByClause(orderBy);
				signViewList = signViewService.selectByExample(example);
			}
			
			
			
			
			
			logger.debug(JSON.toJSONStringWithDateFormat(signViewList,"yyyy-MM-dd HH:mm:ss"));
			
			String json = "";
			if(null != signViewList && signViewList.size()>0){
				json = JSON.toJSONStringWithDateFormat(signViewList,"yyyy-MM-dd HH:mm:ss");
			}
//			
			
			
					
					resp.getWriter().write(json);
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
