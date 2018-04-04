package com.example.factorisation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.factorisation.model.PricelistItems;
import com.example.factorisation.repository.PricelistItemsRepository;
import com.example.factorisation.service.PricelistItemsService;

@Transactional
@Service
public class JpaPricelistItemsService implements PricelistItemsService{

	@Autowired
	private PricelistItemsRepository pricelistItemsRepository;

	public PricelistItems findOne(Long id) {
		return pricelistItemsRepository.findOne(id);
	}
	
	@Override
	public List<PricelistItems> findAll() {
		return pricelistItemsRepository.findAll();
	}
	
	@Override
	public PricelistItems save(PricelistItems pricelistItems) {
		return pricelistItemsRepository.save(pricelistItems);
	}

	@Override
	public List<PricelistItems> save(List<PricelistItems> pricelistitems) {
		return pricelistItemsRepository.save(pricelistitems);
	}
	
	@Override
	public PricelistItems delete(Long id) {
		PricelistItems pricelistItems = pricelistItemsRepository.findOne(id);
		if(pricelistItems == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant PricelistItems");
		}
		pricelistItemsRepository.delete(pricelistItems);
		return pricelistItems;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}

}
