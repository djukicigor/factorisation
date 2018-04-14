package com.example.factorisation.service;

import java.util.List;

import com.example.factorisation.model.GoodsOrServices;

public interface GoodsOrServicesService {
	
	GoodsOrServices findOne(Long id);
	

	List<GoodsOrServices> findAll();
	
	
	GoodsOrServices save(GoodsOrServices goodsOrServices);
	
	
	List<GoodsOrServices> save(List<GoodsOrServices> goodsorservices);
	
	
	GoodsOrServices delete(Long id);
	
	
	void delete(List<Long> ids);
}
