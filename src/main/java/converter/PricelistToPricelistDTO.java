package converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.Pricelist;
import dto.PricelistDTO;

public class PricelistToPricelistDTO implements Converter<Pricelist, PricelistDTO>{

	@Override
	public PricelistDTO convert(Pricelist arg0) {
		
		PricelistDTO p = new PricelistDTO();
		
		p.setId(arg0.getId());
		p.setDate_of_validity(arg0.getDate_of_validity());
		
		/*if(arg0.getCompany() != null) {
			p.setCompanyId(((Pricelist) arg0.getCompany()).getId());
		}*/
		
		if(arg0.getPricelistItems() != null) {
			p.setPricelistItemsId(((Pricelist) arg0.getPricelistItems()).getId());
		}
		
		return p;
	}
	
	public List<PricelistDTO> convert(List<Pricelist> pricelists){
		
		List<PricelistDTO> retVal = new ArrayList<PricelistDTO>();
		
		for (Pricelist pricelist : pricelists) {
			retVal.add(convert(pricelist));
		}
		
		return retVal;	
	}
}
