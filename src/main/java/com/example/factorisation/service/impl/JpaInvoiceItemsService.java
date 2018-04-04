package com.example.factorisation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.factorisation.model.InvoiceItems;
import com.example.factorisation.repository.InvoiceItemsRepository;
import com.example.factorisation.service.InvoiceItemsService;

@Transactional
@Service
public class JpaInvoiceItemsService implements InvoiceItemsService{
	
	@Autowired
	private InvoiceItemsRepository invoiceItemsRepository;
	
	public InvoiceItems findOne(Long id) {
		return invoiceItemsRepository.findOne(id);
	}
	
	@Override
	public List<InvoiceItems> findAll() {
		return invoiceItemsRepository.findAll();
	}

	@Override
	public InvoiceItems save(InvoiceItems invoiceItems) {
		return invoiceItemsRepository.save(invoiceItems);
	}
	
	@Override
	public List<InvoiceItems> save(List<InvoiceItems> invoiceitems) {
		return invoiceItemsRepository.save(invoiceitems);
	}
	
	@Override
	public InvoiceItems delete(Long id) {
		InvoiceItems invoiceItems = invoiceItemsRepository.findOne(id);
		if(invoiceItems == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant invoice items");
		}
		invoiceItemsRepository.delete(invoiceItems);
		return invoiceItems;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}

}
