package com.example.factorisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.factorisation.model.BusinessPartner;

@Repository
public interface BusinessPartnerRepository extends JpaRepository<BusinessPartner, Long>{

}
