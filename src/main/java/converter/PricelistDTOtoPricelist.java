package converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.Company;
import com.example.factorisation.model.Pricelist;
import com.example.factorisation.model.PricelistItems;
import com.example.factorisation.service.CompanyService;
import com.example.factorisation.service.PricelistItemsService;

import dto.PricelistDTO;

public class PricelistDTOtoPricelist implements Converter<PricelistDTO, Pricelist>{

	@Autowired
	
	@Override
	public Pricelist convert(PricelistDTO arg0) {
		
		Pricelist p = new Pricelist();
		
		p.setId(arg0.getId());
		p.setDate_of_validity(arg0.getDate_of_validity());
		
		Company company = CompanyService.findOne(arg0.getCompanyId());
		if(company!=null) {
			p.setCompany(company);
		} 
		
		/*PricelistItems pricelistItems = PricelistItemsService.findOne(arg0.getPricelistItemsId());
		if(pricelistItems!=null) {
			p.setPricelistItems(pricelistItems);
		} 
		*/
		return p;
	}
}
