package converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.BusinessPartner;
import com.example.factorisation.model.City;
import com.example.factorisation.model.Company;
import dto.BusinessPartnerDTO;

public class BusinessPartnerToBusinessPartnerDTO implements Converter<BusinessPartner, BusinessPartnerDTO>{

	@Override
	public BusinessPartnerDTO convert(BusinessPartner arg0) {
		
		BusinessPartnerDTO b = new BusinessPartnerDTO();
		
		b.setId(arg0.getId());
		b.setName(arg0.getName());
		b.setAddress(arg0.getAddress());
		b.setType(arg0.getType());
		
		if(arg0.getCompany() != null) {
			b.setCompanyId(((Company) arg0.getCompany()).getId());
		}
		
		if(arg0.getCity() != null) {
			b.setCityId(((City) arg0.getCity()).getId());
		}
		
		if(arg0.getInvoices() != null) {
			b.setInvoiceId(((BusinessPartner) arg0.getInvoices()).getId());
		}
		
		return b;
	}
	
	public List<BusinessPartnerDTO> convert(List<BusinessPartner> businesspartners){
		
		List<BusinessPartnerDTO> retVal = new ArrayList<BusinessPartnerDTO>();
		
		for (BusinessPartner businessPartner : businesspartners) {
			retVal.add(convert(businessPartner));
		}
		
		return retVal;	
	}
	
	
}
