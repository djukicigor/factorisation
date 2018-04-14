package com.example.factorisation.service;

import java.util.List;

import com.example.factorisation.model.Company;

public interface CompanyService {
	
	Company findOne(Long id);
	

	List<Company> findAll();
	
	
	Company save(Company company);
	
	
	List<Company> save(List<Company> company);
	
	
	Company delete(Long id);
	
	
	void delete(List<Long> ids);

}
