package com.example.factorisation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.factorisation.model.Company;
import com.example.factorisation.service.CompanyService;

@RestController
@RequestMapping(value="/api/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Company>> getCompanies() {

		List<Company> companies = companyService.findAll();

		return new ResponseEntity<>(companies, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Company> getCompany(@PathVariable Long id) {
		Company company = companyService.findOne(id);
		if (company == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(company, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Company> delete(@PathVariable Long id) {
		Company deleted = companyService.delete(id);

		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> add(@Validated @RequestBody Company newCompany, Errors errors) {

		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
		}
		
		Company savedCompany = companyService.save(newCompany);

		return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<Company> edit(@RequestBody Company company,
			@PathVariable Long id) {

		if (id != company.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Company persisted = companyService.save(company);

		return new ResponseEntity<>(persisted, HttpStatus.OK);
	}
}
