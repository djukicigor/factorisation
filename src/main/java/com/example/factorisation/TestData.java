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
		
		BusinessPartner businessPartner1 = new BusinessPartner("Ime ime", "adresa", "123456789", "t", "user", "12345", city5);
		Company company1 = new Company("Telsat", "Servo Mihalja 10", "123456789", "021468630", "telsat.doo@gmail.com", "logo", "admin", "12345", city5);
		
		businessPartner1.addCompany(company1);
		businessPartnerService.save(businessPartner1);
		companyService.save(company1);
		cityService.save(city5);
		
		GoodsOrServices goodsOrServices1 = new GoodsOrServices("ime", "jedinica", groupOfGoods1);
		goodsOrServicesService.save(goodsOrServices1);
		
		GoodsOrServices goodsOrServices2 = new GoodsOrServices("imeime", "jedinica2", groupOfGoods1);
		goodsOrServicesService.save(goodsOrServices2);
		
		Pricelist pricelist1 = new Pricelist(date(), company1);
		pricelistService.save(pricelist1);
		
		
		PricelistItems pricelistItems1 = new PricelistItems(100, pricelist1, goodsOrServices1);
		pricelistItemsService.save(pricelistItems1);
		
		Invoice invoice1 = new Invoice("1", date(), date(), 100, 20, 120, 1, company1, businessYear1, businessPartner1);
		invoiceService.save(invoice1);
		
		InvoiceItems invoiceItems1 = new InvoiceItems(100, 100, 3, 80, 20, 20, 1, invoice1, goodsOrServices1);
		invoiceItemsService.save(invoiceItems1);
		
		InvoiceItems invoiceItems2 = new InvoiceItems(200, 200, 6, 160, 40, 40, 2, invoice1, goodsOrServices2);
		invoiceItemsService.save(invoiceItems2);
		
	}

	private Date date() {
		// TODO Auto-generated method stub
		return null;
	}
}
