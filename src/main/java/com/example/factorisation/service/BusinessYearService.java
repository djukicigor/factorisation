package com.example.factorisation.service;

import java.util.List;

import com.example.factorisation.model.*;

public interface BusinessYearService {

	
	static BusinessYear findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	List<BusinessYear> findAll();
	
	
	BusinessYear save(BusinessYear businessYear);
	
	
	List<BusinessYear> save(List<BusinessYear> businessYears);
	
	
	BusinessYear delete(Long id);
	
	
	void delete(List<Long> ids);
}
