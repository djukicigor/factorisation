package com.example.factorisation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.factorisation.model.GroupOfGoods;
import com.example.factorisation.repository.GroupOfGoodsRepository;
import com.example.factorisation.service.GroupOfGoodsService;

@Transactional
@Service
public class JpaGroupOfGoodsService implements GroupOfGoodsService {

	@Autowired
	private GroupOfGoodsRepository groupOfGoodsRepository;

	public GroupOfGoods findOne(Long id) {
		return groupOfGoodsRepository.findOne(id);
	}
	
	@Override
	public List<GroupOfGoods> findAll() {
		return groupOfGoodsRepository.findAll();
	}

	@Override
	public GroupOfGoods save(GroupOfGoods groupOfGoods) {
		return groupOfGoodsRepository.save(groupOfGoods);
	}

	@Override
	public List<GroupOfGoods> save(List<GroupOfGoods> groupsOfGoods) {
		return groupOfGoodsRepository.save(groupsOfGoods);
	}

	@Override
	public GroupOfGoods delete(Long id) {
		GroupOfGoods groupOfGoods = groupOfGoodsRepository.findOne(id);
		if(groupOfGoods == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant GroupOfGoods");
		}
		groupOfGoodsRepository.delete(groupOfGoods);
		return groupOfGoods;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}

}
