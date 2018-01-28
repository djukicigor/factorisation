package com.example.factorisation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.factorisation.model.BusinessYear;
import com.example.factorisation.repository.BusinessYearRepository;
import com.example.factorisation.service.BusinessYearService;

@Transactional
@Service
public class JpaBusinessYearService implements BusinessYearService {

	@Autowired
	private BusinessYearRepository businessYearRepository;

	@Override
	public BusinessYear findOne(Long id) {
		return businessYearRepository.findOne(id);
	}
	
	@Override
	public List<BusinessYear> findAll() {
		return businessYearRepository.findAll();
	}

	@Override
	public BusinessYear save(BusinessYear businessYear) {
		return businessYearRepository.save(businessYear);
	}

	@Override
	public List<BusinessYear> save(List<BusinessYear> businessYears) {
		return businessYearRepository.save(businessYears);
	}

	@Override
	public BusinessYear delete(Long id) {
		BusinessYear businessYear = businessYearRepository.findOne(id);
		if(businessYear == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant Business Year");
		}
		businessYearRepository.delete(businessYear);
		return businessYear;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}

}
