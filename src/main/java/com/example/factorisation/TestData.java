package com.example.factorisation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.factorisation.model.City;
import com.example.factorisation.model.Company;
import com.example.factorisation.model.GoodsOrServices;
import com.example.factorisation.model.BusinessPartner;
import com.example.factorisation.model.BusinessYear;
import com.example.factorisation.service.CityService;
import com.example.factorisation.service.CompanyService;
import com.example.factorisation.service.GoodsOrServicesService;
import com.example.factorisation.service.BusinessPartnerService;
import com.example.factorisation.service.BusinessYearService;
import com.example.factorisation.model.GroupOfGoods;
import com.example.factorisation.model.Pricelist;
import com.example.factorisation.service.GroupOfGoodsService;
import com.example.factorisation.service.PricelistService;


@Component
public class TestData {
	
	@Autowired
	private CityService	cityService;
	
	@Autowired
	private BusinessYearService	businessYearService;
	
	@Autowired
	private GroupOfGoodsService	groupOfGoodsService;
	
	@Autowired
	private CompanyService	companyService;
	
	@Autowired
	private PricelistService	pricelistService;
	
	@Autowired
	private BusinessPartnerService businessPartnerService;
	
	@Autowired
	private GoodsOrServicesService goodsOrServicesService;
	
	@PostConstruct
	private void init() throws ParseException{
		
		City city1 = new City("Novi Sad", "21000");
		cityService.save(city1);
		
		City city2 = new City("Beograd", "11000");
		cityService.save(city2);
		
		City city3 = new City("Niš", "18000");
		cityService.save(city3);

		City city4 = new City("Kragujevac", "34000");
		cityService.save(city4);
		
		City city5 = new City("Požarevac", "12000");
		cityService.save(city5);
		
		BusinessYear businessYear1 = new BusinessYear(2014, true);
		businessYearService.save(businessYear1);
		
		BusinessYear businessYear2 = new BusinessYear(2015, true);
		businessYearService.save(businessYear2);
		
		BusinessYear businessYear3 = new BusinessYear(2012, false);
		businessYearService.save(businessYear3);
		
		GroupOfGoods groupOfGoods1 = new GroupOfGoods("Tehnologija", 20);
		groupOfGoodsService.save(groupOfGoods1);
		
		Company company1 = new Company("Telsat", "Servo Mihalja 10", "123456789", "021468630", "telsat.doo@gmail.com", "logo", city5);
		companyService.save(company1);
		
		GoodsOrServices goodsOrServices1 = new GoodsOrServices("ime", "jedinica", groupOfGoods1);
		goodsOrServicesService.save(goodsOrServices1);
		
		/*Pricelist pricelist1 = new Pricelist();
		pricelistService.save(pricelist1);
		*/
		
		BusinessPartner businessPartner1 = new BusinessPartner("Ime", "adresa", "t", city5, company1);
		businessPartnerService.save(businessPartner1);
		
	}
}
