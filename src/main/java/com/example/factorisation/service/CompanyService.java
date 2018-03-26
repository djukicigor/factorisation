package com.example.factorisation.service;

import java.util.List;

import com.example.factorisation.model.Company;



public interface CompanyService {
	
	static Company findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	List<Company> findAll();
	
	
	Company save(Company company);
	
	
	List<Company> save(List<Company> company);
	
	
	Company delete(Long id);
	
	
	void delete(List<Long> ids);

}
