package converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.Pricelist;
import com.example.factorisation.model.PricelistItems;
import com.example.factorisation.service.PricelistService;

import dto.PricelistItemsDTO;

public class PricelistItemsDTOtoPricelistItems implements Converter<PricelistItemsDTO, PricelistItems> {

	@Autowired
	private PricelistService pricelistService;
	
	@Override
	public PricelistItems convert(PricelistItemsDTO arg0) {
		
		PricelistItems p = new PricelistItems();
		
		p.setId(arg0.getId());
		p.setPrice(arg0.getPrice());
	
		Pricelist pricelist = pricelistService.findOne(arg0.getPricelistId());
		if(pricelist!=null) {
			p.setPricelist(pricelist);
		}
		
		return p;
	}
	
}
