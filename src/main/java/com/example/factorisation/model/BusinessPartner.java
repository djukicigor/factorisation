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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class BusinessPartner {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="Name cannot be empty")
	@Pattern(regexp="^[a-zA-Z\\s]+$", message="Name can contain only letters")
	@Column(name="Name", columnDefinition="VARCHAR(40)")
	private String name;
	
	@NotBlank(message="Address cannot be empty")
	@Pattern(regexp="^[a-zA-Z\\s]+$", message="Address can contain only letters")
	@Column(name="Address", columnDefinition="VARCHAR(40)")
	private String address;
	
	@NotBlank(message="PIB cannot be empty")
	@Pattern(regexp="^[0-9]+", message="PIB can contain only numbers")
	@Column(name="PIB", columnDefinition="CHAR(9)")
	private String pib;
	
	@NotBlank(message="Type cannot be empty")
	@Pattern(regexp="^[a-zA-Z\\s]+$", message="Type can contain only letters")
	@Column(name="Type", columnDefinition="CHAR(2)")
	private String type;
	
	@NotBlank(message="Username cannot be empty")
	@Pattern(regexp="[^\\s]+", message="Username cannot contain spaces")
	@JsonIgnore
	@Column(name="Username", columnDefinition="VARCHAR(10)")
	private String username;
	
	@NotBlank(message="Password cannot be empty")
	@JsonIgnore
	@Column(name="Password", columnDefinition="VARCHAR(10)")
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(name = "businessPartner_company", joinColumns = @JoinColumn(name = "businesPartner_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"))
	List<Company> companies = new ArrayList<Company>();
	//@ManyToOne(fetch=FetchType.EAGER)
	//private Company company;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private City city;
	
	@JsonIgnore
	@OneToMany(mappedBy="businessPartner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Invoice> invoices = new ArrayList<Invoice>();
	
	public BusinessPartner() {
	}

	
	public BusinessPartner(String name, String address, String pib, String type, String username, String password, City city) {
		this.name = name;
		this.address = address;
		this.pib = pib;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

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
	
	public void addCompany(Company company){
		this.companies.add(company);
		
		if(!company.getBusinessPartners().contains(this)){
			company.addBusinessPartner(this);
		}
	}
	
	public void removeCompany(Company company){
		if(company.getBusinessPartners().contains(this)){
			company.getBusinessPartners().remove(this);
		}
		companies.remove(company);
	}


	public String getPib() {
		return pib;
	}


	public void setPib(String pib) {
		this.pib = pib;
	}

}
