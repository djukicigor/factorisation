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
import javax.persistence.OneToMany;

@Entity
public class GroupOfGoods {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="Name", columnDefinition="VARCHAR(20)")
	private String name;
	
	@Column(name="Percentage", columnDefinition="DECIMAL(3,2)")
	private float percentage;
	
	@OneToMany(mappedBy="groupOfGoods", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<GoodsOrServices> goodsOrServices = new ArrayList<GoodsOrServices>();
	
	public GroupOfGoods() {
	}

	public GroupOfGoods(String name, float percentage) {
		this.name = name;
		this.percentage = percentage;
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

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public List<GoodsOrServices> getGoodsOrServices() {
		return goodsOrServices;
	}

	public void setGoodsOrServices(List<GoodsOrServices> goodsOrServices) {
		this.goodsOrServices = goodsOrServices;
	}

	




}
