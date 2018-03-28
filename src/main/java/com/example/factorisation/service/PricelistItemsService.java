package com.example.factorisation.service;

import java.util.List;

import com.example.factorisation.model.PricelistItems;

public interface PricelistItemsService {

	static PricelistItems findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	List<PricelistItems> findAll();
	
	
	PricelistItems save(PricelistItems pricelistItems);
	
	
	List<PricelistItems> save(List<PricelistItems> pricelistitems);
	
	
	PricelistItems delete(Long id);
	
	
	void delete(List<Long> ids);
}
