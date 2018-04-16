package com.example.factorisation.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.factorisation.model.GoodsOrServices;

@Repository
public interface GoodsOrServicesRepository extends JpaRepository<GoodsOrServices, Long>{
	Page<GoodsOrServices> findAll(Pageable pageRequest);
}
