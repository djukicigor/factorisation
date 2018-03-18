package com.example.factorisation.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pricelist {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="Date_of_validity", columnDefinition="DATETIME")
	private Date date_of_validity;
	
    @OneToOne(mappedBy = "pricelist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Company company;

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

}
