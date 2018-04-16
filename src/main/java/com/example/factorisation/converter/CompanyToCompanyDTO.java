package com.example.factorisation.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.City;
import com.example.factorisation.model.Company;
import com.example.factorisation.model.Pricelist;

import dto.CompanyDTO;

public class CompanyToCompanyDTO implements Converter<Company, CompanyDTO>{
	
	@Override
	public CompanyDTO convert(Company arg0) {
		
		CompanyDTO c = new CompanyDTO();
			
			c.setId(arg0.getId());
			c.setName(arg0.getName());
			c.setAddress(arg0.getAddress());
			c.setPib(arg0.getPib());
			c.setNumber(arg0.getNumber());
			c.setEmail(arg0.getEmail());
			c.setLogo(arg0.getLogo());
			
			if(arg0.getCity() != null) {
				c.setCityId(((City) arg0.getCity()).getId());
			}
			
			if(arg0.getPricelists() != null) {
				c.setPricelistId(((Pricelist) arg0.getPricelists()).getId());
			} 
			
			if(arg0.getBusinessPartners() != null) {
				c.setBusinessPartnersId(((Company) arg0.getBusinessPartners()).getId());
			} 
			
			
			return c;
				
	}
	
public List<CompanyDTO> convert(List<Company> companies){
		
		List<CompanyDTO> retVal = new ArrayList<CompanyDTO>();
		
		for (Company company : companies) {
			retVal.add(convert(company));
		}
		
		return retVal;	
	}

}
