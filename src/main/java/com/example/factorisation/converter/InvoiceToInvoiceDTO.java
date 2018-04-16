package converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.BusinessPartner;
import com.example.factorisation.model.BusinessYear;
import com.example.factorisation.model.Company;
import com.example.factorisation.model.Invoice;
import com.example.factorisation.model.InvoiceItems;
import dto.InvoiceDTO;

public class InvoiceToInvoiceDTO implements Converter<Invoice, InvoiceDTO>{

	@Override
	public InvoiceDTO convert(Invoice arg0) {
		InvoiceDTO i = new InvoiceDTO();
		
		i.setId(arg0.getId());
		i.setInvoiceNumber(arg0.getInvoiceNumber());
		i.setInvoiceDate(arg0.getInvoiceDate());
		i.setValueDate(arg0.getValueDate());
		i.setBase(arg0.getBase());
		i.setTotalPDV(arg0.getTotalPDV());
		i.setPaymentAmount(arg0.getPaymentAmount());
		i.setInvoiceStatus(arg0.getInvoiceStatus());
		
		if(arg0.getCompany() != null) {
			i.setCompanyId(((Company) arg0.getCompany()).getId());
		}
		
		if(arg0.getBusinessYear() != null) {
			i.setBusinessYearId(((BusinessYear) arg0.getBusinessYear()).getId());
		}
		
		if(arg0.getBusinessPartner() != null) {
			i.setBusinessPartnerId(((BusinessPartner) arg0.getBusinessPartner()).getId());
		}
		
		if(arg0.getInvoice_Items() != null) {
			i.setInvoiceItemsId(((InvoiceItems) arg0.getInvoice_Items()).getId());
		}
		
		return i;
		
	}
	
	public List<InvoiceDTO> convert(List<Invoice> invoices){
		
		List<InvoiceDTO> retVal = new ArrayList<InvoiceDTO>();
		
		for (Invoice invoice : invoices) {
			retVal.add(convert(invoice));
		}
		
		return retVal;	
	}
}
