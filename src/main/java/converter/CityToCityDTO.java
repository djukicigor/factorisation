package converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import com.example.factorisation.model.City;
import dto.CityDTO;

public class CityToCityDTO implements Converter<City, CityDTO>{
	
	@Override
	public CityDTO convert(City arg0) {
		
		CityDTO c = new CityDTO();
		
		c.setId(arg0.getId());
		c.setName(arg0.getName());
		c.setPostalCode(arg0.getPostalCode());
		
		if(arg0.getCompanies() != null) {
			c.setCompanyId(((City) arg0.getCompanies()).getId());
		}
		
		return c;
		
	}
	
	public List<CityDTO> convert(List<City> cities){
		
		List<CityDTO> retVal = new ArrayList<CityDTO>();
		
		for (City city : cities) {
			retVal.add(convert(city));
		}
		
		return retVal;	
	}
	

}
