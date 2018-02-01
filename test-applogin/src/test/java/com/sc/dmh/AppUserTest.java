package com.sc.dmh;





import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.sc.dmh.beans.AppUser;

import com.sc.dmh.service.inter.AppUserServiceI;





@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/spring-mybatis.xml"})   
public class AppUserTest {
	
	private static final Logger logger = Logger.getLogger(AppUserTest.class);
	@Autowired
	private AppUserServiceI appUserServiceI;
	
	public AppUserServiceI getAppUserServiceI() {
		return appUserServiceI;
	}

	public void setAppUserServiceI(AppUserServiceI appUserServiceI) {
		this.appUserServiceI = appUserServiceI;
	}

	@Test
	public void testGet() throws Exception {
		
		AppUser  appUser = appUserServiceI.selectByPrimaryKey((long) 1);
		
		
		
		logger.info(JSON.toJSONStringWithDateFormat(appUser, "yyyy-MM-dd HH:mm:ss"));
	}
	
	
	
	
}
