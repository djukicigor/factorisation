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

import com.example.factorisation.model.InvoiceItems;
import com.example.factorisation.service.InvoiceItemsService;

@RestController
@RequestMapping(value = "/api/invoiceitems")
public class InvoiceItemsController {

	@Autowired
	private InvoiceItemsService invoiceItemsService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<InvoiceItems>> getInvoiceItems() {

		List<InvoiceItems> invoiceitems = invoiceItemsService.findAll();

		return new ResponseEntity<>(invoiceitems, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<InvoiceItems> getInvoiceItems(@PathVariable Long id) {
		InvoiceItems invoiceItems = invoiceItemsService.findOne(id);
		if (invoiceItems == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(invoiceItems, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<InvoiceItems> delete(@PathVariable Long id) {
		InvoiceItems deleted = invoiceItemsService.delete(id);

		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<InvoiceItems> add(@RequestBody InvoiceItems newInvoiceItems) {

		InvoiceItems savedInvoiceItems = invoiceItemsService.save(newInvoiceItems);

		return new ResponseEntity<>(savedInvoiceItems, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<InvoiceItems> edit(@RequestBody InvoiceItems invoiceItems,
			@PathVariable Long id) {

		if (id != invoiceItems.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		InvoiceItems persisted = invoiceItemsService.save(invoiceItems);

		return new ResponseEntity<>(persisted, HttpStatus.OK);
	}
}
