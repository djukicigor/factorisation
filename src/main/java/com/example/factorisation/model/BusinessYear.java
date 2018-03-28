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
public class BusinessYear {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="Year", columnDefinition="int(4)")
	private int year;
	
	@Column(name="closed", columnDefinition="boolean")
	private boolean closed;
	
	@OneToMany(mappedBy="businessYear", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Invoice> invoices = new ArrayList<Invoice>();
	
	public BusinessYear() {
	}

	public BusinessYear(int year, boolean closed) {
		this.year = year;
		this.closed = closed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}




}
