package com.sc.dmh;





import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.sc.dmh.beans.Place;

import com.sc.dmh.service.inter.PlaceServiceI;





@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/spring-mybatis.xml"})   
public class PlaceTest {
	
	private static final Logger logger = Logger.getLogger(PlaceTest.class);
	@Autowired
	private PlaceServiceI appUserServiceI;
	
	public PlaceServiceI getPlaceServiceI() {
		return appUserServiceI;
	}

	public void setPlaceServiceI(PlaceServiceI appUserServiceI) {
		this.appUserServiceI = appUserServiceI;
	}

	@Test
	public void testGet() throws Exception {
		
		Place  appUser = appUserServiceI.selectByPrimaryKey((long) 1);
		
		
		
		logger.info(JSON.toJSONStringWithDateFormat(appUser, "yyyy-MM-dd HH:mm:ss"));
	}
	
	
	
	
}
