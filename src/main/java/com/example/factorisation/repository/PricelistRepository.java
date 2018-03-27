package com.example.factorisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.factorisation.model.Pricelist;

@Repository
public interface PricelistRepository extends JpaRepository<Pricelist, Long> {

}
