package com.example.factorisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.factorisation.model.InvoiceItems;

@Repository
public interface InvoiceItemsRepository extends JpaRepository<InvoiceItems, Long>{

}
