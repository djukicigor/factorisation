package com.example.factorisation.service;

import java.util.List;

import com.example.factorisation.model.PricelistItems;

public interface PricelistItemsService {

	PricelistItems findOne(Long id);
	

	List<PricelistItems> findAll();
	
	
	PricelistItems save(PricelistItems pricelistItems);
	
	
	List<PricelistItems> save(List<PricelistItems> pricelistitems);
	
	
	PricelistItems delete(Long id);
	
	
	void delete(List<Long> ids);
}
