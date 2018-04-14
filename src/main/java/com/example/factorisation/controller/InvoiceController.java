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

import com.example.factorisation.model.Invoice;
import com.example.factorisation.service.InvoiceService;

@RestController
@RequestMapping(value = "/api/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Invoice>> getInvoices() {

		List<Invoice> invoices = invoiceService.findAll();

		return new ResponseEntity<>(invoices, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Invoice> getInvoice(@PathVariable Long id) {
		Invoice invoice = invoiceService.findOne(id);
		if (invoice == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(invoice, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Invoice> delete(@PathVariable Long id) {
		Invoice deleted = invoiceService.delete(id);

		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Invoice> add(@RequestBody Invoice newInvoice) {

		Invoice savedInvoice = invoiceService.save(newInvoice);

		return new ResponseEntity<>(savedInvoice, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<Invoice> edit(@RequestBody Invoice invoice,
			@PathVariable Long id) {

		if (id != invoice.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Invoice persisted = invoiceService.save(invoice);

		return new ResponseEntity<>(persisted, HttpStatus.OK);
	}
	
}
