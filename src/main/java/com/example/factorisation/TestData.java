package com.example.factorisation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.factorisation.model.City;
import com.example.factorisation.model.BusinessYear;
import com.example.factorisation.service.CityService;
import com.example.factorisation.service.BusinessYearService;
import com.example.factorisation.model.GroupOfGoods;
import com.example.factorisation.service.GroupOfGoodsService;


@Component
public class TestData {
	
	@Autowired
	private CityService	cityService;
	
	@Autowired
	private BusinessYearService	businessYearService;
	
	@Autowired
	private GroupOfGoodsService	groupOfGoodsService;
	
	
	@PostConstruct
	private void init(){
		
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
		
		
	}
}
