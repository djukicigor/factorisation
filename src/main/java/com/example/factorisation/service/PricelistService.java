package com.example.factorisation.service;

import java.util.List;

import com.example.factorisation.model.Pricelist;

public interface PricelistService {

	Pricelist findOne(Long id);
	
	
	List<Pricelist> findAll();
	
	
	Pricelist save(Pricelist pricelist);
	
	
	List<Pricelist> save(List<Pricelist> pricelists);
	
	
	Pricelist delete(Long id);
	
	
	void delete(List<Long> ids);
}
