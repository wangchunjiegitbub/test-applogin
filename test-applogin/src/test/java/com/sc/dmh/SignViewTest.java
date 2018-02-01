package com.sc.dmh;





import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.sc.dmh.beans.SignView;
import com.sc.dmh.beans.SignViewExample;
import com.sc.dmh.beans.SignViewExample.Criteria;
import com.sc.dmh.service.inter.SignViewServiceI;





@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/spring-mybatis.xml"})   
public class SignViewTest {
	
	private static final Logger logger = Logger.getLogger(SignViewTest.class);
	@Autowired
	private SignViewServiceI appUserServiceI;
	
	public SignViewServiceI getSignViewServiceI() {
		return appUserServiceI;
	}

	public void setSignViewServiceI(SignViewServiceI appUserServiceI) {
		this.appUserServiceI = appUserServiceI;
	}

	@Test
	public void testGet() throws Exception {
		
		SignViewExample example = new SignViewExample();
		Criteria c = example.createCriteria();
		c.andIdEqualTo(1);
		List<SignView> a = appUserServiceI.selectByExample(example);
		
		
		
		logger.info(JSON.toJSONStringWithDateFormat(a, "yyyy-MM-dd HH:mm:ss"));
	}
	
	
	
	
}
