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

import com.example.factorisation.model.BusinessPartner;
import com.example.factorisation.model.Company;
import com.example.factorisation.service.BusinessPartnerService;

@RestController
@RequestMapping(value = "/api/businesspartners")
public class BusinessPartnerController {

	@Autowired
	private BusinessPartnerService businessPartnerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BusinessPartner>> getBusinessPartners() {

		List<BusinessPartner> businessPartners = businessPartnerService.findAll();

		return new ResponseEntity<>(businessPartners, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BusinessPartner> getBusinessPartner(@PathVariable Long id) {
		BusinessPartner businessPartner = businessPartnerService.findOne(id);
		if (businessPartner == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(businessPartner, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<BusinessPartner> delete(@PathVariable Long id) {
		BusinessPartner deleted = businessPartnerService.delete(id);

		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> add(@Validated @RequestBody BusinessPartner newBusinessPartner, Errors errors) {

		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
		}
		
		BusinessPartner savedBusinessPartner = businessPartnerService.save(newBusinessPartner);

		return new ResponseEntity<>(savedBusinessPartner, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> login(@Validated @RequestBody BusinessPartner newPartner, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
		}
		
		List<BusinessPartner> businessPartners = businessPartnerService.findAll();
		
		for (BusinessPartner businessPartner : businessPartners) {
			if (businessPartner.getUsername().equals(newPartner.getUsername()) && businessPartner.getPassword().equals(newPartner.getPassword())) {
				return new ResponseEntity<>(businessPartner, HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<String>("Wrong username or password", HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<BusinessPartner> edit(@RequestBody BusinessPartner businessPartner,
			@PathVariable Long id) {

		if (id != businessPartner.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		BusinessPartner persisted = businessPartnerService.save(businessPartner);

		return new ResponseEntity<>(persisted, HttpStatus.OK);
	}
}
