package com.example.factorisation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.factorisation.model.Invoice;
import com.example.factorisation.repository.InvoiceRepository;
import com.example.factorisation.service.InvoiceService;

@Transactional
@Service
public class JpaInvoiceService implements InvoiceService{

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	public Invoice findOne(Long id) {
		return invoiceRepository.findOne(id);
	}
	
	@Override
	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}
	
	@Override
	public Invoice save(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	
	@Override
	public List<Invoice> save(List<Invoice> invoices) {
		return invoiceRepository.save(invoices);
	}
	
	@Override
	public Invoice delete(Long id) {
		Invoice invoice = invoiceRepository.findOne(id);
		if(invoice == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant invoice");
		}
		invoiceRepository.delete(invoice);
		return invoice;
	}
	
	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}
}
