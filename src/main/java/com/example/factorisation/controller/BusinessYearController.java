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

import com.example.factorisation.model.BusinessYear;
import com.example.factorisation.service.BusinessYearService;

@RestController
@RequestMapping(value = "/api/businessYears")
public class BusinessYearController {

		@Autowired
		private BusinessYearService businessYearService;

		@RequestMapping(value="getBusinessYears", method = RequestMethod.GET)
		public ResponseEntity<List<BusinessYear>> getBusinessYears() {

			List<BusinessYear> businessYears = businessYearService.findAll();

			return new ResponseEntity<>(businessYears, HttpStatus.OK);
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<BusinessYear> getBusinessYear(@PathVariable Long id) {
			BusinessYear businessYear = businessYearService.findOne(id);
			if (businessYear == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(businessYear, HttpStatus.OK);
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<BusinessYear> delete(@PathVariable Long id) {
			BusinessYear deleted = businessYearService.delete(id);

			return new ResponseEntity<>(deleted, HttpStatus.OK);
		}

		@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
		public ResponseEntity<BusinessYear> add(@RequestBody BusinessYear newBusinessYear) {

			BusinessYear savedBusinessYear = businessYearService.save(newBusinessYear);

			return new ResponseEntity<>(savedBusinessYear, HttpStatus.CREATED);
		}

		@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
		public ResponseEntity<BusinessYear> edit(@RequestBody BusinessYear businessYear,
				@PathVariable Long id) {

			if (id != businessYear.getId()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			BusinessYear persisted = businessYearService.save(businessYear);

			return new ResponseEntity<>(persisted, HttpStatus.OK);
		}
	
}
