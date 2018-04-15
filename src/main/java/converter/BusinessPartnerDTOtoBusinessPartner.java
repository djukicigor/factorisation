package converter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.BusinessPartner;
import com.example.factorisation.model.City;
import com.example.factorisation.model.Company;
import com.example.factorisation.model.Invoice;
import com.example.factorisation.service.CityService;
import com.example.factorisation.service.CompanyService;
import com.example.factorisation.service.InvoiceService;

import dto.BusinessPartnerDTO;

public class BusinessPartnerDTOtoBusinessPartner implements Converter<BusinessPartnerDTO,BusinessPartner>{

	@Autowired
	private CityService cityService;
	
	@Autowired
	private CompanyService companyService;
	
	@Override
	public BusinessPartner convert(BusinessPartnerDTO arg0) {
		
		BusinessPartner b = new BusinessPartner();
		
		b.setId(arg0.getId());
		b.setName(arg0.getName());
		b.setAddress(arg0.getAddress());
		b.setPib(arg0.getPib());
		b.setType(arg0.getType());
		
		/*Company company = companyService.findOne(arg0.getCompanyId());
		if(company!=null) {
			b.setCompanies(company);
		}
		*/
		
		City city = cityService.findOne(arg0.getCityId());
		if(city!=null) {
			b.setCity(city);
		}
		
		/*Invoice invoice = InvoiceService.findOne(arg0.getInvoiceId());
		if(invoice!=null) {
			b.setInvoices(invoice);
		}
		*/
		
		return b;
	}
}
