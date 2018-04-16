package com.example.factorisation.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class PricelistItems {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="Price", columnDefinition="DECIMAL(6,2)")
	private float price;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	private Pricelist pricelist;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private GoodsOrServices goodsOrServices;
	
	public PricelistItems() {
	}

	public PricelistItems(float price, Pricelist pricelist, GoodsOrServices goodsOrServices) {
		this.price = price;
		this.pricelist = pricelist;
		this.goodsOrServices = goodsOrServices;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Pricelist getPricelist() {
		return pricelist;
	}

	public void setPricelist(Pricelist pricelist) {
		this.pricelist = pricelist;
	}

	public GoodsOrServices getGoodsOrServices() {
		return goodsOrServices;
	}

	public void setGoodsOrServices(GoodsOrServices goodsOrServices) {
		this.goodsOrServices = goodsOrServices;
	}
}
