package com.example.factorisation.service;

import java.util.List;

import com.example.factorisation.model.InvoiceItems;



public interface InvoiceItemsService {

	static InvoiceItems findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	List<InvoiceItems> findAll();
	
	
	InvoiceItems save(InvoiceItems invoiceItems);
	
	
	List<InvoiceItems> save(List<InvoiceItems> invoiceitems);
	
	
	InvoiceItems delete(Long id);
	
	
	void delete(List<Long> ids);
}
