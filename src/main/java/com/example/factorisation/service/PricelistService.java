package com.example.factorisation.service;

import java.util.List;

import com.example.factorisation.model.Pricelist;

public interface PricelistService {

	
	static Pricelist findOne(Long id) {
		
		return null;
	}
	
	List<Pricelist> findAll();
	
	Pricelist save(Pricelist pricelist);
	
	List<Pricelist> save(List<Pricelist> pricelists);
	
	Pricelist delete(Long id);
	
	void delete(List<Long> ids);
}
