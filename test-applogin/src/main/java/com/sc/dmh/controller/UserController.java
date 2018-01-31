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
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.sc.dmh.annotation.AuthPassport;
import com.sc.dmh.beans.CbhsUser;
import com.sc.dmh.beans.CbhsUserExample;
import com.sc.dmh.beans.UserData;
import com.sc.dmh.beans.CbhsUserExample.Criteria;

import com.sc.dmh.service.inter.UserServiceI;



@Controller
//@RequestMapping("/userController")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private UserServiceI userService;
	
	

	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
	
		
	
	//自定义权限验证注解加注解时表示有权限是才能访问
//	@AuthPassport
	//请求的路径
	@RequestMapping("/index")
	public String showIndex( 
			HttpServletRequest request, 
			HttpServletResponse resp) 
			throws IOException {
			//返回的视图
		
			return "index";
		}
	
	
	//自定义权限验证注解加注解时表示有权限是才能访问
//	@AuthPassport
	//请求的路径-退出方法
	@RequestMapping("/quit")
	public String quit( 
			HttpServletRequest request, 
			HttpServletResponse resp) 
			throws IOException {
			//Session失效，里面的所有东西都会清空了，同时也释放了资源。
			request.getSession().invalidate();
			//返回的视图
			return "login";
			}
	
	
	
	//登陆控制器
	@RequestMapping("/appLogin")
	public void showUser(String data, CbhsUser formUserdmh, 
			HttpServletRequest request, 
			HttpServletResponse resp) 
			throws IOException {//@PathVariable String id(路径变量如@RequestMapping("/{id}/showUser"))
		
		logger.info(data);
		ObjectMapper mapper = new ObjectMapper();  
		UserData userData = mapper.readValue(data, UserData.class);
		logger.info(JSON.toJSONString(userData));

		// {"total":10 , "rows":[{},{}]}
		String json = "{\"result\":\"checkOK\",\"token\":\"123\"}";
		
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
