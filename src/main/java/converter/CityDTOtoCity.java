package converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.City;

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
		
		/*Company company = companyService.findOne(arg0.getCompanyId());
		if(company!=null) {
			c.setCompany(company);
		}
		*/
		return c;
	}

}
