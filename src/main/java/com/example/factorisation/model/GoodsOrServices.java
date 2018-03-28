package com.example.factorisation.model;



import java.util.ArrayList;
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

@Entity
public class GoodsOrServices {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="Name", columnDefinition="VARCHAR(50)")
	private String name;
	
	@Column(name="Unit", columnDefinition="VARCHAR(15)")
	private String unit;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private GroupOfGoods groupOfGoods;
	
	@OneToMany(mappedBy="goodsOrServices", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<PricelistItems> pricelistItems = new ArrayList<PricelistItems>();
	
	@OneToMany(mappedBy="goodsOrServices", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<InvoiceItems> invoiceItems = new ArrayList<InvoiceItems>();
	
	public GoodsOrServices() {
	}

	public GoodsOrServices(String name, String unit) {
		this.name = name;
		this.unit = unit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public GroupOfGoods getGroupOfGoods() {
		return groupOfGoods;
	}

	public void setGroupOfGoods(GroupOfGoods groupOfGoods) {
		this.groupOfGoods = groupOfGoods;
	}

	public List<PricelistItems> getPricelistItems() {
		return pricelistItems;
	}

	public void setPricelistItems(List<PricelistItems> pricelistItems) {
		this.pricelistItems = pricelistItems;
	}

	public List<InvoiceItems> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItems> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}




}
