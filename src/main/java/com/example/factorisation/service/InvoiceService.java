package com.example.factorisation.service;

import java.util.List;
import com.example.factorisation.model.Invoice;

public interface InvoiceService {

	Invoice findOne(Long id);
	

	List<Invoice> findAll();
	
	
	Invoice save(Invoice invoice);
	
	
	List<Invoice> save(List<Invoice> invoices);
	
	
	Invoice delete(Long id);
	
	
	void delete(List<Long> ids);
}
