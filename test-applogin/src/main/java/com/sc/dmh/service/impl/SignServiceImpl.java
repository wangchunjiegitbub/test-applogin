package com.sc.dmh.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sc.dmh.beans.Sign;
import com.sc.dmh.beans.SignExample;

import com.sc.dmh.mapper.SignMapper;

import com.sc.dmh.service.inter.SignServiceI;




@Service
@Transactional
public class SignServiceImpl extends AbstractService<Sign, SignExample, Long> implements SignServiceI {
	
	@Autowired
	private SignMapper signMapper;

	public void setAppUserMapper(SignMapper signMapper) {
		this.signMapper = signMapper;
	}
	
	//这句必须要加上。不然会报空指针异常，因为在实际掉用的时候不是BaseMapper调用，而是这个productMapper
	  @Autowired
	  public void setBaseMapper(){
	    super.setBaseMapper(signMapper);
	  }

	

}
