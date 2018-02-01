package com.sc.dmh.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sc.dmh.beans.SignView;
import com.sc.dmh.beans.SignViewExample;

import com.sc.dmh.mapper.SignViewMapper;

import com.sc.dmh.service.inter.SignViewServiceI;




@Service
@Transactional
public class SignViewServiceImpl extends AbstractService<SignView, SignViewExample, Long> implements SignViewServiceI {
	
	@Autowired
	private SignViewMapper signViewMapper;

	public void setAppUserMapper(SignViewMapper signViewMapper) {
		this.signViewMapper = signViewMapper;
	}
	
	//这句必须要加上。不然会报空指针异常，因为在实际掉用的时候不是BaseMapper调用，而是这个productMapper
	  @Autowired
	  public void setBaseMapper(){
	    super.setBaseMapper(signViewMapper);
	  }

	

}
