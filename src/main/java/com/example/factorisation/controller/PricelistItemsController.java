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

import com.example.factorisation.converter.PricelistItemsDTOtoPricelistItems;
import com.example.factorisation.model.PricelistItems;
import com.example.factorisation.service.PricelistItemsService;

import dto.PricelistItemsDTO;

@RestController
@RequestMapping(value = "/api/pricelistitems")
public class PricelistItemsController {

	@Autowired
	private PricelistItemsService pricelistItemsService;
	
	@Autowired
	private PricelistItemsDTOtoPricelistItems toPricelistItems;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PricelistItems>> getPricelistItems() {

		List<PricelistItems> pricelistitems = pricelistItemsService.findAll();

		return new ResponseEntity<>(pricelistitems, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PricelistItems> getPricelistItems(@PathVariable Long id) {
		PricelistItems pricelistItems = pricelistItemsService.findOne(id);
		if (pricelistItems == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(pricelistItems, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PricelistItems> delete(@PathVariable Long id) {
		PricelistItems deleted = pricelistItemsService.delete(id);

		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<PricelistItems> add(@RequestBody PricelistItemsDTO pricelistItemsDTO) {

		PricelistItems savedPricelistItems = pricelistItemsService.save(toPricelistItems.convert(pricelistItemsDTO));

		return new ResponseEntity<>(savedPricelistItems, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<PricelistItems> edit(@RequestBody PricelistItems pricelistItems,
			@PathVariable Long id) {

		if (id != pricelistItems.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		PricelistItems persisted = pricelistItemsService.save(pricelistItems);

		return new ResponseEntity<>(persisted, HttpStatus.OK);
	}

}
