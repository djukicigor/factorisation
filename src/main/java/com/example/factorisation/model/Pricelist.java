package com.example.factorisation.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pricelist {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="Date_of_validity", columnDefinition="DATETIME")
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date date_of_validity;
	
    
	@ManyToOne(fetch=FetchType.EAGER)
    private Company company;
	
	@OneToMany(mappedBy="pricelist", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<PricelistItems> pricelist_Items = new ArrayList<PricelistItems>();
	
	public Pricelist() {
	}

	public Pricelist(Date date_of_validity, Company company) {
		this.date_of_validity = date_of_validity;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate_of_validity() {
		return date_of_validity;
	}

	public void setDate_of_validity(Date date_of_validity) {
		this.date_of_validity = date_of_validity;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<PricelistItems> getPricelist_Items() {
		return pricelist_Items;
	}

	public void setPricelist_Items(List<PricelistItems> pricelist_Items) {
		this.pricelist_Items = pricelist_Items;
	}



}