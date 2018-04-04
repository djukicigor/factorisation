package com.example.factorisation.service;

import java.util.List;

import com.example.factorisation.model.BusinessPartner;

public interface BusinessPartnerService {

	static BusinessPartner findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	List<BusinessPartner> findAll();
	
	
	BusinessPartner save(BusinessPartner businessPartner);
	
	
	List<BusinessPartner> save(List<BusinessPartner> businesspartners);
	
	
	BusinessPartner delete(Long id);
	
	
	void delete(List<Long> ids);
}
