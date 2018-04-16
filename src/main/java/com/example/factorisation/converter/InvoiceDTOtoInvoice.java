package converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.BusinessPartner;
import com.example.factorisation.model.BusinessYear;
import com.example.factorisation.model.Company;
import com.example.factorisation.model.Invoice;
import com.example.factorisation.model.InvoiceItems;
import com.example.factorisation.service.BusinessPartnerService;
import com.example.factorisation.service.BusinessYearService;
import com.example.factorisation.service.CompanyService;

import dto.InvoiceDTO;

public class InvoiceDTOtoInvoice implements Converter<InvoiceDTO, Invoice>{

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private BusinessYearService businessYearService;
	
	@Override
	public Invoice convert(InvoiceDTO arg0) {
		
		Invoice i = new Invoice();
		
		i.setId(arg0.getId());
		i.setInvoiceNumber(arg0.getInvoiceNumber());
		i.setInvoiceDate(arg0.getInvoiceDate());
		i.setValueDate(arg0.getValueDate());
		i.setBase(arg0.getBase());
		i.setTotalPDV(arg0.getTotalPDV());
		i.setPaymentAmount(arg0.getPaymentAmount());
		i.setInvoiceStatus(arg0.getInvoiceStatus());
		
		Company company = companyService.findOne(arg0.getCompanyId());
		if(company!=null) {
			i.setCompany(company);
		}
		
		BusinessYear businessYear = businessYearService.findOne(arg0.getBusinessYearId());
		if(businessYear!=null) {
			i.setBusinessYear(businessYear);
		}
		
		/*BusinessPartner businessPartner = BusinessPartnerService.findOne(arg0.getBusinessPartnerId());
		if(businessPartner!=null) {
			i.setBusinessPartner(businessPartner);
		}
		
		InvoiceItems invoiceItems = InvoiceItemsService.findOne(arg0.getInvoiceItemsId());
		if(invoiceItems!=null) {
			i.setInvoiceItems(invoiceItems);
		}
		*/
		
		return i;
	}
}
