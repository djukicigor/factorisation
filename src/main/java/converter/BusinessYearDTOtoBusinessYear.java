package converter;

import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.BusinessYear;
import com.example.factorisation.model.Invoice;
import com.example.factorisation.service.InvoiceService;

import dto.BusinessYearDTO;

public class BusinessYearDTOtoBusinessYear implements Converter<BusinessYearDTO, BusinessYear>{
	
	@Override
	public BusinessYear convert(BusinessYearDTO arg0) {
		
		BusinessYear b = new BusinessYear();
		
		b.setId(arg0.getId());
		b.setYear(arg0.getYear());
		b.setClosed(arg0.getClosed());
		
		/*Invoice invoice = InvoiceService.findOne(arg0.getInvoiceId());
		if(invoice!=null) {
			b.setInvoices(invoice);
		}
		*/
		
		return b;
	}

}
