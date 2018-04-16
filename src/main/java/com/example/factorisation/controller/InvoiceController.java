package com.example.factorisation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.factorisation.converter.InvoiceDTOtoInvoice;
import com.example.factorisation.converter.InvoiceToInvoiceDTO;
import com.example.factorisation.model.Company;
import com.example.factorisation.model.Invoice;
import com.example.factorisation.service.CompanyService;
import com.example.factorisation.service.InvoiceService;

import dto.InvoiceDTO;

@RestController
@RequestMapping(value = "/api/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private InvoiceDTOtoInvoice toInvoice;
	
	@Autowired
	private InvoiceToInvoiceDTO toInvoiceDTO;
	
	@RequestMapping(value = "/{id}/{type}", method = RequestMethod.GET)
	public ResponseEntity<List<Invoice>> getInvoices(@PathVariable Long id, @PathVariable String type) {
		List<Invoice> invoices = invoiceService.findAll();
		List<Invoice> newInvoices = new ArrayList<Invoice>();
			for (Invoice invoice : invoices) {					
				if (type.equals("company")) {
					if (id == invoice.getCompany().getId()) {
						newInvoices.add(invoice);
					}
				} else {				
					if (id == invoice.getBusinessPartner().getId()) {
						newInvoices.add(invoice);
					}
				}
			}

		return new ResponseEntity<>(newInvoices, HttpStatus.OK);
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
	public ResponseEntity<Invoice> add(@RequestBody InvoiceDTO invoiceDTO) {

		Invoice savedInvoice = invoiceService.save(toInvoice.convert(invoiceDTO));
		return new ResponseEntity<>(savedInvoice, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<Invoice> edit(@RequestBody Invoice invoice,
			@PathVariable Long id) {
		
		if (id != invoice.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Invoice changedInvoice = invoiceService.findOne(id);
		changedInvoice.setInvoiceStatus(invoice.getInvoiceStatus());

		Invoice persisted = invoiceService.save(changedInvoice);

		return new ResponseEntity<>(persisted, HttpStatus.OK);
	}
	
}
