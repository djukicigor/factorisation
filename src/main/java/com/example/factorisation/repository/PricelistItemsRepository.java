package com.example.factorisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.factorisation.model.PricelistItems;

@Repository
public interface PricelistItemsRepository extends JpaRepository<PricelistItems, Long> {

}
