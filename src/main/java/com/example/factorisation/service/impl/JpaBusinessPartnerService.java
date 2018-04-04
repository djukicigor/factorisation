package com.example.factorisation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.factorisation.model.BusinessPartner;
import com.example.factorisation.repository.BusinessPartnerRepository;
import com.example.factorisation.service.BusinessPartnerService;


@Transactional
@Service
public class JpaBusinessPartnerService implements BusinessPartnerService {

	@Autowired
	private BusinessPartnerRepository businessPartnerRepository;
	
	public BusinessPartner findOne(Long id) {
		return businessPartnerRepository.findOne(id);
	}
	
	@Override
	public List<BusinessPartner> findAll() {
		return businessPartnerRepository.findAll();
	}

	@Override
	public BusinessPartner save(BusinessPartner businessPartner) {
		return businessPartnerRepository.save(businessPartner);
	}

	@Override
	public List<BusinessPartner> save(List<BusinessPartner> businesspartners) {
		return businessPartnerRepository.save(businesspartners);
	}
	
	@Override
	public BusinessPartner delete(Long id) {
		BusinessPartner businessPartner = businessPartnerRepository.findOne(id);
		if(businessPartner == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant business partner");
		}
		businessPartnerRepository.delete(businessPartner);
		return businessPartner;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}
}
