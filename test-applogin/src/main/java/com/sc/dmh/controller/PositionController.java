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

import com.sc.dmh.beans.Place;
import com.sc.dmh.beans.PlaceExample;
import com.sc.dmh.beans.PlaceExample.Criteria;
import com.sc.dmh.service.inter.PlaceServiceI;
import com.sc.dmh.service.inter.SignServiceI;
import com.sc.dmh.service.inter.SignViewServiceI;




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



		//登陆控制器
		@RequestMapping("/getCurrentPosition")
		public void getCurrentPosition(String data,
				HttpServletRequest request, 
				HttpServletResponse resp) 
				throws IOException {//@PathVariable String id(路径变量如@RequestMapping("/{id}/showUser"))
			
			resp.setContentType("text/html;charset=utf-8");	
			
			if(null == data){
				logger.info("isempty");
				return;
			}
			logger.debug(data);
			
			ObjectMapper mapper = new ObjectMapper();  
			Place place = mapper.readValue(data, Place.class);
			
			//设置查询条件为两点间的数据
			PlaceExample example = new PlaceExample();
			Criteria c = example.createCriteria();
			c.andLatitudeWestLessThanOrEqualTo(place.getLatitude());
			c.andLatitudeEastGreaterThanOrEqualTo(place.getLatitude());
			c.andLongitudeWestLessThanOrEqualTo(place.getLongitude());
			c.andLongitudeEastGreaterThanOrEqualTo(place.getLongitude());
			
			List<Place> placeAll = placeService.selectByExample(example);
			
			if( !placeAll.isEmpty() && placeAll.size()>0 ){
				
				
			}else{
				
			}
			// {"total":10 , "rows":[{},{}]}
			String json = "{\"result\":\"1\",\"token\":\"123\"}";
			
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
