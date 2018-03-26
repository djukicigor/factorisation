package com.example.factorisation.service;

import java.util.List;

import com.example.factorisation.model.*;

public interface CityService {

	
	static City findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	List<City> findAll();
	
	
	City save(City city);
	
	
	List<City> save(List<City> cities);
	
	
	City delete(Long id);
	
	
	void delete(List<Long> ids);
}
