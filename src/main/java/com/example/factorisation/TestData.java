package com.example.factorisation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;

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
import com.example.factorisation.model.Invoice;
import com.example.factorisation.model.InvoiceItems;
import com.example.factorisation.model.Pricelist;
import com.example.factorisation.model.PricelistItems;
import com.example.factorisation.service.GroupOfGoodsService;
import com.example.factorisation.service.InvoiceItemsService;
import com.example.factorisation.service.InvoiceService;
import com.example.factorisation.service.PricelistService;
import com.example.factorisation.service.PricelistItemsService;


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
	private PricelistItemsService	pricelistItemsService;
	
	@Autowired
	private BusinessPartnerService businessPartnerService;
	
	@Autowired
	private GoodsOrServicesService goodsOrServicesService;
	
	@Autowired
	private InvoiceItemsService invoiceItemsService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@PostConstruct
	private void init() throws ParseException{
		
		City city1 = new City("NoviSad", "21000");
		cityService.save(city1);
		
		City city2 = new City("Beograd", "11000");
		cityService.save(city2);
		
		City city3 = new City("Nis", "18000");
		cityService.save(city3);

		City city4 = new City("Kragujevac", "34000");
		cityService.save(city4);
		
		City city5 = new City("Pozarevac", "12000");
		cityService.save(city5);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		BusinessYear businessYear1 = new BusinessYear(Integer.parseInt(df.format(date)), true);
		businessYearService.save(businessYear1);
		
		BusinessYear businessYear2 = new BusinessYear(2015, true);
		businessYearService.save(businessYear2);
		
		BusinessYear businessYear3 = new BusinessYear(2016, false);
		businessYearService.save(businessYear3);
		
		GroupOfGoods groupOfGoods1 = new GroupOfGoods("Tehnologija", 20);
		groupOfGoodsService.save(groupOfGoods1);
		
		GroupOfGoods groupOfGoods2 = new GroupOfGoods("Hrana", 30);
		groupOfGoodsService.save(groupOfGoods2);
		
		GroupOfGoods groupOfGoods3 = new GroupOfGoods("Pice", 15);
		groupOfGoodsService.save(groupOfGoods3);
		
		BusinessPartner businessPartner1 = new BusinessPartner("Zoran", "Veljka Petrovica 8", "123456789", "tip1", "user1", "12345", city5);
		Company company1 = new Company("Telsat", "Servo Mihalja 10", "123456789", "021468630", "telsat.doo@gmail.com", "logo1", "admin1", "12345", city5);
		
		businessPartner1.addCompany(company1);
		businessPartnerService.save(businessPartner1);
		companyService.save(company1);
		cityService.save(city5);
		
		BusinessPartner businessPartner2 = new BusinessPartner("Goran", "Turgenjeva 4", "987654321", "tip2", "user2", "12345", city4);
		Company company2 = new Company("Vega", "Dragise Brasovana 2", "987654321", "021456987", "vega.doo@gmail.com", "logo2", "admin2", "12345", city4);
		
		businessPartner2.addCompany(company2);
		businessPartnerService.save(businessPartner2);
		companyService.save(company2);
		cityService.save(city4);
		
		BusinessPartner businessPartner3 = new BusinessPartner("Bojan", "Puskinova 55", "564879213", "tip3", "user3", "12345", city3);
		Company company3 = new Company("Bambi", "Kralja Aleksandra 9", "546879213", "021478521", "bambi.doo@gmail.com", "logo3", "admin3", "12345", city3);
		
		businessPartner3.addCompany(company3);
		businessPartnerService.save(businessPartner3);
		companyService.save(company3);
		cityService.save(city3);
		
		GoodsOrServices goodsOrServices1 = new GoodsOrServices("Hleb", "kg", groupOfGoods1);
		goodsOrServicesService.save(goodsOrServices1);
		
		GoodsOrServices goodsOrServices2 = new GoodsOrServices("Fanta", "kom", groupOfGoods2);
		goodsOrServicesService.save(goodsOrServices2);
		
		GoodsOrServices goodsOrServices3 = new GoodsOrServices("Pegla", "kom", groupOfGoods3);
		goodsOrServicesService.save(goodsOrServices3);
		
		Pricelist pricelist1 = new Pricelist(date(), company1);
		pricelistService.save(pricelist1);
		
		Pricelist pricelist2 = new Pricelist(date(), company1);
		pricelistService.save(pricelist2);
		
		Pricelist pricelist3 = new Pricelist(date(), company1);
		pricelistService.save(pricelist3);
		
		PricelistItems pricelistItems1 = new PricelistItems(100, pricelist1, goodsOrServices1);
		pricelistItemsService.save(pricelistItems1);
		
		PricelistItems pricelistItems2 = new PricelistItems(100, pricelist2, goodsOrServices2);
		pricelistItemsService.save(pricelistItems2);
		
		PricelistItems pricelistItems3 = new PricelistItems(100, pricelist3, goodsOrServices3);
		pricelistItemsService.save(pricelistItems3);
		
		Invoice invoice1 = new Invoice("1", date(), date(), 100, 20, 120, 0, company1, businessYear1, businessPartner1);
		invoiceService.save(invoice1);
		
		Invoice invoice2 = new Invoice("2", date(), date(), 200, 10, 135, 1, company1, businessYear2, businessPartner1);
		invoiceService.save(invoice2);
		
		Invoice invoice3 = new Invoice("3", date(), date(), 300, 30, 150, 2, company1, businessYear3, businessPartner1);
		invoiceService.save(invoice3);
		
		InvoiceItems invoiceItems1 = new InvoiceItems(100, 100, 3, 80, 20, 20, 1, invoice1, goodsOrServices1);
		invoiceItemsService.save(invoiceItems1);
		
		InvoiceItems invoiceItems2 = new InvoiceItems(200, 200, 6, 160, 40, 40, 2, invoice2, goodsOrServices2);
		invoiceItemsService.save(invoiceItems2);
		
		InvoiceItems invoiceItems3 = new InvoiceItems(150, 300, 4, 230, 50, 30, 1, invoice3, goodsOrServices3);
		invoiceItemsService.save(invoiceItems3);
	}

	private Date date() {
		// TODO Auto-generated method stub
		return null;
	}
}
