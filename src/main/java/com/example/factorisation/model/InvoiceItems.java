package com.example.factorisation.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class InvoiceItems {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="Amount",columnDefinition="DECIMAL(4,2)")      
    private float amount;
	
	@Column(name="UnitPrice",columnDefinition="DECIMAL(6,2)")      
    private float unitPrice;
	
	@Column(name="Rebate",columnDefinition="DECIMAL(3,2)")      
    private float rebate;
	
	@Column(name="BasePDV",columnDefinition="DECIMAL(6,2)")      
    private float basePDV;
	
	@Column(name="PercentagePDV",columnDefinition="DECIMAL(3,2)")      
    private float percentagePDV;
	
	@Column(name="AmountPDV",columnDefinition="DECIMAL(6,2)")      
    private float amountPDV;
	
	@Column(name="AmountItems",columnDefinition="DECIMAL(6,2)")      
    private float amountItems;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Invoice invoice;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private GoodsOrServices goodsOrServices;
	
	public InvoiceItems() {
	}

	public InvoiceItems(float amount, float unitPrice, float rebate, float basePDV, float percentagePDV, float amountPDV, float amountItems) {
		this.amount = amount;
		this.unitPrice = unitPrice;
		this.rebate = rebate;
		this.basePDV = basePDV;
		this.percentagePDV = percentagePDV;
		this.amountPDV = amountPDV;
		this.amountItems = amountItems;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public float getRebate() {
		return rebate;
	}

	public void setRebate(float rebate) {
		this.rebate = rebate;
	}

	public float getBasePDV() {
		return basePDV;
	}

	public void setBasePDV(float basePDV) {
		this.basePDV = basePDV;
	}

	public float getPercentagePDV() {
		return percentagePDV;
	}

	public void setPercentagePDV(float percentagePDV) {
		this.percentagePDV = percentagePDV;
	}

	public float getAmountPDV() {
		return amountPDV;
	}

	public void setAmountPDV(float amountPDV) {
		this.amountPDV = amountPDV;
	}

	public float getAmountItems() {
		return amountItems;
	}

	public void setAmountItems(float amountItems) {
		this.amountItems = amountItems;
	}


	public GoodsOrServices getGoodsOrServices() {
		return goodsOrServices;
	}

	public void setGoodsOrServices(GoodsOrServices goodsOrServices) {
		this.goodsOrServices = goodsOrServices;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
