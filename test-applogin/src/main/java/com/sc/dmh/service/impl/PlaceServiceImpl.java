package com.sc.dmh.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sc.dmh.beans.Place;
import com.sc.dmh.beans.PlaceExample;

import com.sc.dmh.mapper.PlaceMapper;

import com.sc.dmh.service.inter.PlaceServiceI;




@Service
@Transactional
public class PlaceServiceImpl extends AbstractService<Place, PlaceExample, Long> implements PlaceServiceI {
	
	@Autowired
	private PlaceMapper placeMapper;

	public void setAppUserMapper(PlaceMapper placeMapper) {
		this.placeMapper = placeMapper;
	}
	
	//这句必须要加上。不然会报空指针异常，因为在实际掉用的时候不是BaseMapper调用，而是这个productMapper
	  @Autowired
	  public void setBaseMapper(){
	    super.setBaseMapper(placeMapper);
	  }

	

}
