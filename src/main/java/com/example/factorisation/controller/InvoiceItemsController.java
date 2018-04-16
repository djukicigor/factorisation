package com.example.factorisation.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.factorisation.converter.InvoiceDTOtoInvoice;
import com.example.factorisation.converter.InvoiceItemsDTOtoInvoiceItems;
import com.example.factorisation.model.Invoice;
import com.example.factorisation.model.InvoiceItems;
import com.example.factorisation.service.InvoiceItemsService;
import com.example.factorisation.service.InvoiceService;

import dto.InvoiceDTO;
import dto.InvoiceItemsDTO;

@RestController
@RequestMapping(value = "/api/invoiceitems")
public class InvoiceItemsController {

	@Autowired
	private InvoiceItemsService invoiceItemsService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private InvoiceItemsDTOtoInvoiceItems toInvoiceItem;
	
	@Autowired
	private InvoiceDTOtoInvoice toInvoice;
	
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
	public ResponseEntity<Invoice> add(@RequestBody List<InvoiceItemsDTO> arrInvoiceItemsDTO) {
		Random rand = new Random();
		List<Long> arr = new ArrayList<Long>();
		InvoiceDTO newInvoiceDTO = new InvoiceDTO(Long.valueOf(rand.nextInt(50) + 1), Integer.toString(rand.nextInt(50) + 1), new Date(), new Date(), 1, Long.valueOf(3));
		for(InvoiceItemsDTO invoiceItemsDTO : arrInvoiceItemsDTO) {
			newInvoiceDTO.setCompanyId(invoiceItemsDTO.getCompanyId());
			newInvoiceDTO.setBusinessPartnerId(invoiceItemsDTO.getBusinessPartnerId());
			InvoiceItems savedInvoiceItems = invoiceItemsService.save(toInvoiceItem.convert(invoiceItemsDTO));
			arr.add(savedInvoiceItems.getId());
		}
		newInvoiceDTO.setInvoiceItemIds(arr);
		Invoice newInvoice = invoiceService.save(toInvoice.convert(newInvoiceDTO));
		for(Long n : arr) {
			InvoiceItems i = invoiceItemsService.findOne(n);
			i.setInvoice(newInvoice);
			invoiceItemsService.save(i);
		}
		return new ResponseEntity<>(newInvoice, HttpStatus.CREATED);
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
