package converter;

import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.BusinessPartner;
import com.example.factorisation.model.City;
import com.example.factorisation.model.Company;
import com.example.factorisation.model.Pricelist;
import com.example.factorisation.service.BusinessPartnerService;
import com.example.factorisation.service.CityService;
import com.example.factorisation.service.PricelistService;

import dto.CompanyDTO;

public class CompanyDTOtoCompany implements Converter<CompanyDTO, Company>{
	
	@Override
	public Company convert(CompanyDTO arg0) {
		
		Company c = new Company();
		
		c.setId(arg0.getId());
		c.setName(arg0.getName());
		c.setAddress(arg0.getAddress());
		c.setPib(arg0.getPib());
		c.setNumber(arg0.getNumber());
		c.setEmail(arg0.getEmail());
		c.setLogo(arg0.getLogo());
		
		City city = CityService.findOne(arg0.getCityId());
		if(city!=null) {
			c.setCity(city);
		}
		
		/*Pricelist pricelist = PricelistService.findOne(arg0.getPricelistId());
		if(pricelist!=null) {
			c.setPricelists(pricelist);
		}
		
		BusinessPartner businessPartner = BusinessPartnerService.findOne(arg0.getBusinessPartnersId());
		if(businessPartner!=null) {
			c.setBusinessPartners(businessPartner);
		}
		*/
		
		return c;
	}

}
