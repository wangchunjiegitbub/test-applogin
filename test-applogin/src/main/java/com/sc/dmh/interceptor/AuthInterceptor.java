package com.sc.dmh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sc.dmh.annotation.AuthPassport;


public class AuthInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = Logger.getLogger(AuthInterceptor.class);
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	response.setContentType("text/html;charset=utf-8");
    	
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);
            
            //没有声明需要权限,或者声明不验证权限
                if(authPassport == null || authPassport.validate() == false)
                return true;
            else{  
            	
                //在这里实现自己的权限验证逻辑
                if(request.getSession().getAttribute("sessionUser") != null){
                	logger.debug(request.getSession().getAttribute("sessionUser"));
                	//如果验证成功返回true（这里直接写false来模拟验证失败的处理）
                	return true;
                }
                else//如果验证失败
                {
                    //返回到登录界面
                	
                	
                	
                	String json = "{\"result\":\"-99\",\"message\":\"您还没有登陆请重新登陆！\"}";
    				
                	response.getWriter().write(json);
                	return false;
                }       
            }
        }
        else
            return true;   
     }
}