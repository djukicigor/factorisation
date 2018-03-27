package com.example.factorisation.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Invoice {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="InvoiceNumber", columnDefinition="CHAR(15)")
	private String invoiceNumber;
	
	@Column(name="InvoiceDate",columnDefinition="DATETIME")      
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date invoiceDate;
	
	@Column(name="ValueDate",columnDefinition="DATETIME")      
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date valueDate;
	
	@Column(name="Base",columnDefinition="DECIMAL(6,2)")      
    private float base;
	
	@Column(name="TotalPDV",columnDefinition="DECIMAL(10,2)")      
    private float totalPDV;
	
	@Column(name="PaymentAmount",columnDefinition="DECIMAL(6,2)")      
    private float paymentAmount;
	
	@Column(name="InvoiceStatus",columnDefinition="CHAR(5)")      
    private String invoiceStatus;
	
	public Invoice() {
	}

	public Invoice(String invoiceNumber, Date invoiceDate, Date valueDate, float base, float totalPDV, float paymentAmount, String invoiceStatus) {
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.valueDate = valueDate;
		this.base = base;
		this.totalPDV = totalPDV;
		this.paymentAmount = paymentAmount;
		this.invoiceStatus = invoiceStatus;

	}
}
