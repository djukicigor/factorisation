package converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.City;
import com.example.factorisation.model.Company;

import dto.CityDTO;
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
			
			/*if(arg0.getCity() != null) {
				c.setCityId(((Company) arg0.getCity()).getId());
			}
			
			if(arg0.getPricelist() != null) {
				c.setPricelistId(((Company) arg0.getPricelist()).getId());
			} 
			*/
			
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
