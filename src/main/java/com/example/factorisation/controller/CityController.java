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

import com.example.factorisation.model.City;
import com.example.factorisation.service.CityService;

@RestController
@RequestMapping(value = "/api/cities")
public class CityController {

		@Autowired
		private CityService cityService;

		@RequestMapping(value="getCities", method = RequestMethod.GET)
		public ResponseEntity<List<City>> getCities() {
			System.out.print("Dosao");
			List<City> cities = cityService.findAll();
			
			return new ResponseEntity<>(cities, HttpStatus.OK);
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<City> getCity(@PathVariable Long id) {
			City city = CityService.findOne(id);
			if (city == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(city, HttpStatus.OK);
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<City> delete(@PathVariable Long id) {
			City deleted = cityService.delete(id);

			return new ResponseEntity<>(deleted, HttpStatus.OK);
		}

		@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
		public ResponseEntity<City> add(@RequestBody City newCity) {

			City savedCity = cityService.save(newCity);

			return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
		}

		@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
		public ResponseEntity<City> edit(@RequestBody City city,
				@PathVariable Long id) {

			if (id != city.getId()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			City persisted = cityService.save(city);

			return new ResponseEntity<>(persisted, HttpStatus.OK);
		}
	
}
