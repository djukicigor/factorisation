package com.example.factorisation.service;

import java.util.List;

import com.example.factorisation.model.InvoiceItems;

public interface InvoiceItemsService {

	InvoiceItems findOne(Long id);
	

	List<InvoiceItems> findAll();
	
	
	InvoiceItems save(InvoiceItems invoiceItems);
	
	
	List<InvoiceItems> save(List<InvoiceItems> invoiceitems);
	
	
	InvoiceItems delete(Long id);
	
	
	void delete(List<Long> ids);
}
