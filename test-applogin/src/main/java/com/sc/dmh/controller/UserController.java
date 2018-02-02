package com.sc.dmh.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.sc.dmh.annotation.AuthPassport;
import com.sc.dmh.beans.AppUser;
import com.sc.dmh.beans.AppUserExample;
import com.sc.dmh.beans.CbhsUser;
import com.sc.dmh.beans.CbhsUserExample;
import com.sc.dmh.beans.UserData;
import com.sc.dmh.beans.CbhsUserExample.Criteria;
import com.sc.dmh.beans.Place;
import com.sc.dmh.service.inter.AppUserServiceI;
import com.sc.dmh.service.inter.UserServiceI;
import com.sc.dmh.util.Md5Util;



@Controller
//@RequestMapping("/userController")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private AppUserServiceI appUserService;
			
	public void setAppUserService(AppUserServiceI appUserService) {
		this.appUserService = appUserService;
	}




	
	
	
	//登陆控制器
	@RequestMapping("/appLogin")
	public void showUser(String data,  
			HttpServletRequest request, 
			HttpServletResponse resp) 
			throws IOException {//@PathVariable String id(路径变量如@RequestMapping("/{id}/showUser"))
		
		resp.setContentType("text/html;charset=utf-8");	
		logger.debug(data);
		String json = "";
		
		
		if(null == data){
			logger.info("isempty");
			return;
		}
		
		ObjectMapper mapper = new ObjectMapper();  
		AppUser userData = mapper.readValue(data, AppUser.class);
		logger.debug(JSON.toJSONString(userData));
		
//		1.验证用户token是否存在，
//		2.如果存在验证uuid与token
//		3.保存用户到session返回验证通过
		//自动登录设置
		if(null != userData  && null != userData.getToken()){
			
			
			AppUserExample example = new AppUserExample();
			com.sc.dmh.beans.AppUserExample.Criteria c = example.createCriteria();
			c.andTokenEqualTo(userData.getToken());
			c.andUuidEqualTo(userData.getUuid());
			List<AppUser> userList = appUserService.selectByExample(example );
			if(userList.size()==1){
				//保存用户到session中
				request.getSession().setAttribute("sessionUser", userList.get(0));
				json = "{\"result\":\"tokenOK\"}";
				resp.getWriter().write(json);
				return;
				
			}
			
			
		}
		
		//用户名密码登录
		if(null != userData  && null != userData.getWageNumber() && null != userData.getPassword() && null != userData.getUuid() ){
			
			AppUserExample example = new AppUserExample();
			com.sc.dmh.beans.AppUserExample.Criteria c = example.createCriteria();
			c.andWageNumberEqualTo(userData.getWageNumber());
			c.andPasswordEqualTo(userData.getPassword());
			List<AppUser> userList = appUserService.selectByExample(example );
			//根据用户劳资号加密码验证通过
			if(userList.size()==1){
				
				String token = Md5Util.getMD5(userList.get(0).getWageNumber()  + new Date());
				userList.get(0).setToken(token );
				userList.get(0).setUuid(userData.getUuid());
				int i = appUserService.updateByExample(userList.get(0), example);
				logger.debug("updateByExample:" + i);
				//保存用户到session中
				request.getSession().setAttribute("sessionUser", userList.get(0));
				json = "{\"result\":\"checkOK\",\"token\":\""  + userList.get(0).getToken() + "\"}";
						
				resp.getWriter().write(json);
				return;
				
			}
			
			
		}
		
		json = "{\"result\":\"-1\"}";
		
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
