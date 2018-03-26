package com.example.factorisation.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.factorisation.model.Company;
import com.example.factorisation.repository.CompanyRepository;
import com.example.factorisation.service.CompanyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Transactional
@Service
public class JpaCompanyService implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public Company findOne(Long id) {
		return companyRepository.findOne(id);
	}
	
	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	@Override
	public Company save(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public List<Company> save(List<Company> companies) {
		return companyRepository.save(companies);
	}
	
	@Override
	public Company delete(Long id) {
		Company company = companyRepository.findOne(id);
		if(company == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant company");
		}
		companyRepository.delete(company);
		return company;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}
}
