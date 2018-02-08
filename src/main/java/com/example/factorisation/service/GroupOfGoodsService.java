package com.example.factorisation.service;

import java.util.List;

import com.example.factorisation.model.*;

public interface GroupOfGoodsService {

	
	GroupOfGoods findOne(Long id);
	

	List<GroupOfGoods> findAll();
	
	
	GroupOfGoods save(GroupOfGoods groupOfGoods);
	
	
	List<GroupOfGoods> save(List<GroupOfGoods> groupsOfGoods);
	
	
	GroupOfGoods delete(Long id);
	
	
	void delete(List<Long> ids);
}
