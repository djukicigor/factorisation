package com.example.factorisation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class BusinessPartner {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="Name", columnDefinition="VARCHAR(40)")
	private String name;
	
	@Column(name="Address", columnDefinition="VARCHAR(40)")
	private String address;
	
	@Column(name="Type", columnDefinition="CHAR(2)")
	private String type;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Company company;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private City city;
	
	public BusinessPartner() {
	}

	public BusinessPartner(String name, String address, String type) {
		this.name = name;
		this.address = address;
		this.type = type;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	

}