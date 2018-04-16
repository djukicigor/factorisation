package com.example.factorisation.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.GoodsOrServices;
import com.example.factorisation.model.Invoice;
import com.example.factorisation.model.InvoiceItems;
import com.example.factorisation.service.CityService;
import com.example.factorisation.service.GoodsOrServicesService;
import com.example.factorisation.service.InvoiceService;

import dto.InvoiceItemsDTO;

public class InvoiceItemsDTOtoInvoiceItems implements Converter<InvoiceItemsDTO, InvoiceItems>{

	@Autowired
	private GoodsOrServicesService goodsOrServicesService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Override
	public InvoiceItems convert(InvoiceItemsDTO arg0) {
		
		InvoiceItems i = new InvoiceItems();
		
		i.setId(arg0.getId());
		i.setAmount(arg0.getAmount());
		i.setUnitPrice(arg0.getUnitPrice());
		i.setRebate(arg0.getRebate());
		i.setBasePDV(arg0.getBasePDV());
		i.setPercentagePDV(arg0.getPercentagePDV());
		i.setAmountPDV(arg0.getAmountPDV());
		i.setAmountItems(arg0.getAmountItems());
		
		Invoice invoice = invoiceService.findOne(arg0.getInvoiceId());
		if(invoice!=null) {
			i.setInvoice(invoice);
		}
		
		GoodsOrServices goodsOrServices = goodsOrServicesService.findOne(arg0.getGoodsOrservicesId());
		if(goodsOrServices!=null) {
			i.setGoodsOrServices(goodsOrServices);
		}
		
		
		return i;
	}
}
