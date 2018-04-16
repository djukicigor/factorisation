package converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import com.example.factorisation.model.GoodsOrServices;
import com.example.factorisation.model.Invoice;
import com.example.factorisation.model.InvoiceItems;
import dto.InvoiceItemsDTO;

public class InvoiceItemsToInvoiceItemsDTO implements Converter<InvoiceItems, InvoiceItemsDTO>{

	@Override
	public InvoiceItemsDTO convert(InvoiceItems arg0) {
		
		InvoiceItemsDTO i = new InvoiceItemsDTO();
		
		i.setId(arg0.getId());
		i.setAmount(arg0.getAmount());
		i.setUnitPrice(arg0.getUnitPrice());
		i.setRebate(arg0.getRebate());
		i.setBasePDV(arg0.getBasePDV());
		i.setPercentagePDV(arg0.getPercentagePDV());
		i.setAmountPDV(arg0.getAmountPDV());
		i.setAmountItems(arg0.getAmountItems());
		
		if(arg0.getInvoice() != null) {
			i.setInvoiceId(((Invoice) arg0.getInvoice()).getId());
		}
		
		if(arg0.getGoodsOrServices() != null) {
			i.setGoodsOrservicesId(((GoodsOrServices) arg0.getGoodsOrServices()).getId());
		}
		
		return i;
	}
	
	public List<InvoiceItemsDTO> convert(List<InvoiceItems> invoiceitems){
		
		List<InvoiceItemsDTO> retVal = new ArrayList<InvoiceItemsDTO>();
		
		for (InvoiceItems invoiceItems : invoiceitems) {
			retVal.add(convert(invoiceItems));
		}
		
		return retVal;	
	}
}
