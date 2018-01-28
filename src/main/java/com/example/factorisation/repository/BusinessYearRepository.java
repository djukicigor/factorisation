package com.example.factorisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.factorisation.model.BusinessYear;

@Repository
public interface BusinessYearRepository extends JpaRepository<BusinessYear, Long>{
	
}
