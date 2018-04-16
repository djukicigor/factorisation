package converter;

import java.util.ArrayList;
import org.springframework.core.convert.converter.Converter;
import com.example.factorisation.model.BusinessYear;

import java.util.List;
import dto.BusinessYearDTO;

public class BusinessYearToBusinessYearDTO implements Converter<BusinessYear, BusinessYearDTO>{

	@Override
	public BusinessYearDTO convert(BusinessYear arg0) {
		
		BusinessYearDTO b = new BusinessYearDTO();
		
		b.setId(arg0.getId());
		b.setYear(arg0.getYear());
		b.setClosed(arg0.isClosed());
		
		if(arg0.getInvoices() != null) {
			b.setInvoiceId(((BusinessYear) arg0.getInvoices()).getId());
		}
		
		return b;
	}
	
	public List<BusinessYearDTO> convert(List<BusinessYear> businessyears){
		
		List<BusinessYearDTO> retVal = new ArrayList<BusinessYearDTO>();
		
		for (BusinessYear businessyear : businessyears) {
			retVal.add(convert(businessyear));
		}
		
		return retVal;
	}
}
