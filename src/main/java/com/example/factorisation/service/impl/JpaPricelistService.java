package com.example.factorisation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.factorisation.model.Pricelist;
import com.example.factorisation.repository.PricelistRepository;
import com.example.factorisation.service.PricelistService;

@Transactional
@Service
public class JpaPricelistService implements PricelistService{
	
	@Autowired
	private PricelistRepository pricelistRepository;
	
	public Pricelist findOne(Long id) {
		return pricelistRepository.findOne(id);
	}
	
	@Override
	public List<Pricelist> findAll() {
		return pricelistRepository.findAll();
	}
	
	@Override
	public Pricelist save(Pricelist pricelist) {
		return pricelistRepository.save(pricelist);
	}
	
	@Override
	public Pricelist delete(Long id) {
		Pricelist pricelist = pricelistRepository.findOne(id);
		if(pricelist == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant pricelist");
		}
		pricelistRepository.delete(pricelist);
		return pricelist;
	}
	
	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}

	@Override
	public List<Pricelist> save(List<Pricelist> pricelists) {
		// TODO Auto-generated method stub
		return null;
	}

}
