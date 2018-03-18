package com.example.factorisation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Company {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="Name", columnDefinition="VARCHAR(40)")
	private String name;
	
	@Column(name="Address", columnDefinition="VARCHAR(40)")
	private String address;
	
	@Column(name="PIB", columnDefinition="CHAR(9)")
	private String pib;
	
	@Column(name="Number", columnDefinition="VARCHAR(15)")
	private String number;
	
	@Column(name="Email", columnDefinition="VARCHAR(40)")
	private String email;
	
	@Column(name="Logo", columnDefinition="VARCHAR(40)")
	private String logo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private City city;
	
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pricelist_id", nullable = false)
    private Pricelist pricelist;
	
	public Company() {
	}

	public Company(String name, String address, String pib, String number, String email, String logo) {
		this.name = name;
		this.address = address;
		this.pib = pib;
		this.number = number;
		this.email = email;
		this.logo = logo;
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

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
		if(city!=null && !city.getCompanies().contains(this)){
			city.getCompanies().add(this);
		}
	}

	public Pricelist getPricelist() {
		return pricelist;
	}

	public void setPricelist(Pricelist pricelist) {
		this.pricelist = pricelist;
	}
}
