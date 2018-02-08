package com.example.factorisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.factorisation.model.GroupOfGoods;

@Repository
public interface GroupOfGoodsRepository extends JpaRepository<GroupOfGoods, Long>{
	
}
