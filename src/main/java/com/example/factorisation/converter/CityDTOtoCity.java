package converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.BusinessPartner;
import com.example.factorisation.model.City;
import com.example.factorisation.model.Company;
import com.example.factorisation.service.BusinessPartnerService;
import com.example.factorisation.service.CompanyService;

import dto.CityDTO;

public class CityDTOtoCity implements Converter<CityDTO, City>{
	
	@Autowired
	//private CompanyService companyService;
	
	@Override
	public City convert(CityDTO arg0) {
		
		City c = new City();
		
		c.setId(arg0.getId());
		c.setName(arg0.getName());
		c.setPostalCode(arg0.getPostalCode());
		
		/*Company company = CompanyService.findOne(arg0.getCompanyId());
		if(company!=null) {
			c.setCompanies(company);
		}
		
		BusinessPartner businessPartner = BusinessPartnerService.findOne(arg0.getBusinessPartnerId());
		if(businessPartner!=null) {
			c.setBusinessPartners(businessPartner);
		*/
		
		return c;
	}

}
