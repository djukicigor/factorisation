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
public class City {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="Name cannot be empty")
	@Pattern(regexp="^[a-zA-Z\\s]+$", message="Name can contain only letters")
	@Column(name="Name", columnDefinition="VARCHAR(40)")
	private String name;
	
	@NotBlank(message="Postal code cannot be empty")
	@Pattern(regexp="^[0-9]+", message="Postal code can contain only numbers")
	@Column(name="D_CODE", columnDefinition="CHAR(5)")
	private String postalCode;
	
	@JsonIgnore
	@OneToMany(mappedBy="city", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Company> companies = new ArrayList<Company>();
	
	@JsonIgnore
	@OneToMany(mappedBy="city", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<BusinessPartner> businessPartners = new ArrayList<BusinessPartner>();
	
	public City() {
	}

	public City(String name, String postalCode) {
		this.name = name;
		this.postalCode = postalCode;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	
	public void addCompany(Company company){
		this.companies.add(company);
		
		if(company.getCity()!=this){
			company.setCity(this);
		}
	}
	
	public void removeCompany(Company company){
		company.setCity(null);
		companies.remove(company);
	}

	public List<BusinessPartner> getBusinessPartners() {
		return businessPartners;
	}

	public void setBusinessPartners(List<BusinessPartner> businessPartners) {
		this.businessPartners = businessPartners;
	}

}
