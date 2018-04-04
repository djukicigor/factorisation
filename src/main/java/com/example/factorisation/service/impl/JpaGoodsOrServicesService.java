package com.example.factorisation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.factorisation.model.GoodsOrServices;
import com.example.factorisation.repository.GoodsOrServicesRepository;
import com.example.factorisation.service.GoodsOrServicesService;

@Transactional
@Service
public class JpaGoodsOrServicesService implements GoodsOrServicesService{

	@Autowired
	private GoodsOrServicesRepository goodsOrServicesRepository;
	
	public GoodsOrServices findOne(Long id) {
		return goodsOrServicesRepository.findOne(id);
	}
	
	@Override
	public List<GoodsOrServices> findAll() {
		return goodsOrServicesRepository.findAll();
	}

	@Override
	public GoodsOrServices save(GoodsOrServices goodsOrServices) {
		return goodsOrServicesRepository.save(goodsOrServices);
	}
	
	@Override
	public List<GoodsOrServices> save(List<GoodsOrServices> goodsorservices) {
		return goodsOrServicesRepository.save(goodsorservices);
	}
	
	@Override
	public GoodsOrServices delete(Long id) {
		GoodsOrServices goodsOrServices = goodsOrServicesRepository.findOne(id);
		if(goodsOrServices == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant goods or services");
		}
		goodsOrServicesRepository.delete(goodsOrServices);
		return goodsOrServices;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}
}
