package com.example.factorisation.service;

import java.util.List;

import com.example.factorisation.model.*;

public interface BusinessYearService {

	BusinessYear findOne(Long id);
	

	List<BusinessYear> findAll();
	
	
	BusinessYear save(BusinessYear businessYear);
	
	
	List<BusinessYear> save(List<BusinessYear> businessYears);
	
	
	BusinessYear delete(Long id);
	
	
	void delete(List<Long> ids);
}
