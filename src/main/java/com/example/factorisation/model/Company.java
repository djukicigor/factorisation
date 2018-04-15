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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;


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
	
	@Column(name="Username", columnDefinition="VARCHAR(10)")
	private String username;
	
	@Column(name="Password", columnDefinition="VARCHAR(10)")
	private String password;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="city_id")
	private City city;
	
	@JsonIgnore
	@ManyToMany(mappedBy="companies", fetch=FetchType.LAZY)
	List<BusinessPartner> businessPartners = new ArrayList<BusinessPartner>();
	//@OneToMany(mappedBy="company", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	//private List<BusinessPartner> businessPartners = new ArrayList<BusinessPartner>();
	
	@JsonIgnore
	@OneToMany(mappedBy="company", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Invoice> invoices = new ArrayList<Invoice>();
    
	@JsonIgnore
    @OneToMany(mappedBy="company", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Pricelist> pricelists = new ArrayList<Pricelist>();
	
	public Company() {
	}

	public Company(String name, String address, String pib, String number, String email, String logo, String username, String password, City city) {
		this.name = name;
		this.address = address;
		this.pib = pib;
		this.number = number;
		this.email = email;
		this.logo = logo;
		this.username = username;
		this.password = password;
		this.city = city;
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


	public List<BusinessPartner> getBusinessPartners() {
		return businessPartners;
	}

	public void setBusinessPartners(List<BusinessPartner> businessPartners) {
		this.businessPartners = businessPartners;
	}

	public List<Pricelist> getPricelists() {
		return pricelists;
	}

	public void setPricelists(List<Pricelist> pricelists) {
		this.pricelists = pricelists;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

<<<<<<< HEAD
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
=======
>>>>>>> ec02e26921007ecf24340bc2daed632f6937beea
}
