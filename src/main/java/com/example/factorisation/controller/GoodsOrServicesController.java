package com.example.factorisation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.factorisation.model.GoodsOrServices;
import com.example.factorisation.repository.GoodsOrServicesRepository;
import com.example.factorisation.service.GoodsOrServicesService;

@RestController
@RequestMapping(value = "/api/goodsorservices")
public class GoodsOrServicesController {

	@Autowired
	private GoodsOrServicesService goodsOrServicesService;
	
	@Autowired
	private GoodsOrServicesRepository goodsOrServicesRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<GoodsOrServices>> getGoodsOrServices() {

		Page<GoodsOrServices> goodsorservices = goodsOrServicesRepository.findAll(new PageRequest(0, 5));
		
		return new ResponseEntity<>(goodsorservices.getContent(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getPages",method = RequestMethod.GET)
	public ResponseEntity<Number> getNumber() {
		
		Page<GoodsOrServices> goodsorservices = goodsOrServicesRepository.findAll(new PageRequest(0, 5));
		
		return new ResponseEntity<>(goodsorservices.getTotalPages(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<GoodsOrServices> getGoodsOrServices(@PathVariable Long id) {
		GoodsOrServices goodsOrServices = goodsOrServicesService.findOne(id);
		if (goodsOrServices == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(goodsOrServices, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<GoodsOrServices> delete(@PathVariable Long id) {
		GoodsOrServices deleted = goodsOrServicesService.delete(id);

		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> add(@Validated @RequestBody GoodsOrServices newGoodsOrServices, Errors errors) {

		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
		}
		
		GoodsOrServices savedGoodsOrServices = goodsOrServicesService.save(newGoodsOrServices);

		return new ResponseEntity<>(savedGoodsOrServices, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<GoodsOrServices> edit(@RequestBody GoodsOrServices goodsOrServices,
			@PathVariable Long id) {

		if (id != goodsOrServices.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		GoodsOrServices persisted = goodsOrServicesService.save(goodsOrServices);

		return new ResponseEntity<>(persisted, HttpStatus.OK);
	}
}
