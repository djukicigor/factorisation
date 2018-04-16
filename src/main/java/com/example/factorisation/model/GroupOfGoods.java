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
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class GroupOfGoods {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="Name cannot be empty")
	@Pattern(regexp="^[a-zA-Z\\s]+$", message="Name can contain only letters")
	@Column(name="Name", columnDefinition="VARCHAR(20)")
	private String name;
	
	@Column(name="Percentage", columnDefinition="DECIMAL(3,2)")
	private float percentage;
	
	@JsonIgnore
	@OneToMany(mappedBy="groupOfGoods", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<GoodsOrServices> goods_Or_Services = new ArrayList<GoodsOrServices>();
	
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

	public List<GoodsOrServices> getGoods_Or_Services() {
		return goods_Or_Services;
	}

	public void setGoods_Or_Services(List<GoodsOrServices> goods_Or_Services) {
		this.goods_Or_Services = goods_Or_Services;
	}



	




}
