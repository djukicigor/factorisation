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
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Company company;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private BusinessYear businessYear;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private BusinessPartner businessPartner;
	
	@OneToMany(mappedBy="invoice", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<InvoiceItems> invoiceItems = new ArrayList<InvoiceItems>();
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public float getBase() {
		return base;
	}

	public void setBase(float base) {
		this.base = base;
	}

	public float getTotalPDV() {
		return totalPDV;
	}

	public void setTotalPDV(float totalPDV) {
		this.totalPDV = totalPDV;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public BusinessYear getBusinessYear() {
		return businessYear;
	}

	public void setBusinessYear(BusinessYear businessYear) {
		this.businessYear = businessYear;
	}

	public BusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}

	public List<InvoiceItems> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItems> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}
}
