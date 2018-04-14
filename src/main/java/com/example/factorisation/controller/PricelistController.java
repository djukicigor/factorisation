package com.example.factorisation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.factorisation.model.Pricelist;
import com.example.factorisation.service.PricelistService;

@RestController
@RequestMapping(value = "/api/pricelists")
public class PricelistController {

	@Autowired
	private PricelistService pricelistService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pricelist>> getPricelists() {

		List<Pricelist> pricelists = pricelistService.findAll();

		return new ResponseEntity<>(pricelists, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pricelist> getPricelist(@PathVariable Long id) {
		Pricelist pricelist = pricelistService.findOne(id);
		if (pricelist == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(pricelist, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Pricelist> delete(@PathVariable Long id) {
		Pricelist deleted = pricelistService.delete(id);

		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Pricelist> add(@RequestBody Pricelist newPricelist) {

		Pricelist savedPricelist = pricelistService.save(newPricelist);

		return new ResponseEntity<>(savedPricelist, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<Pricelist> edit(@RequestBody Pricelist pricelist,
			@PathVariable Long id) {

		if (id != pricelist.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Pricelist persisted = pricelistService.save(pricelist);

		return new ResponseEntity<>(persisted, HttpStatus.OK);
	}
	
}
