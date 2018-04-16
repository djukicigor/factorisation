package com.example.factorisation.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.factorisation.model.GoodsOrServices;
import com.example.factorisation.model.Pricelist;
import com.example.factorisation.model.PricelistItems;
import com.example.factorisation.service.GoodsOrServicesService;
import com.example.factorisation.service.PricelistService;

import dto.PricelistItemsDTO;

@Component
public class PricelistItemsDTOtoPricelistItems implements Converter<PricelistItemsDTO, PricelistItems> {

	@Autowired
	private PricelistService pricelistService;
	
	@Autowired
	private GoodsOrServicesService goodsOrServicesService;
	
	@Override
	public PricelistItems convert(PricelistItemsDTO arg0) {
		
		PricelistItems p = new PricelistItems();
		
		p.setId(arg0.getId());
		p.setPrice(arg0.getPrice());
	
		Pricelist pricelist = pricelistService.findOne(arg0.getPricelistId());
		if(pricelist!=null) {
			p.setPricelist(pricelist);
		}
		
		GoodsOrServices goodsOrService = goodsOrServicesService.findOne(arg0.getPricelistId());
		if(goodsOrService!=null) {
			p.setGoodsOrServices(goodsOrService);
		}
		
		return p;
	}
	
}
