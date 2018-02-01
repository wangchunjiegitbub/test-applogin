package com.sc.dmh.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.dmh.beans.AppUser;
import com.sc.dmh.beans.AppUserExample;


import com.sc.dmh.mapper.AppUserMapper;

import com.sc.dmh.service.inter.AppUserServiceI;




@Service
@Transactional
public class AppUserServiceImpl extends AbstractService<AppUser, AppUserExample, Long> implements AppUserServiceI {
	
	@Autowired
	private AppUserMapper appUserMapper;

	public void setAppUserMapper(AppUserMapper appUserMapper) {
		this.appUserMapper = appUserMapper;
	}
	
	//这句必须要加上。不然会报空指针异常，因为在实际掉用的时候不是BaseMapper调用，而是这个productMapper
	  @Autowired
	  public void setBaseMapper(){
	    super.setBaseMapper(appUserMapper);
	  }

	

}
