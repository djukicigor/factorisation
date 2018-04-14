package converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.GoodsOrServices;
import com.example.factorisation.model.GroupOfGoods;
import com.example.factorisation.model.InvoiceItems;
import com.example.factorisation.model.PricelistItems;
import com.example.factorisation.service.CompanyService;
import com.example.factorisation.service.GroupOfGoodsService;
import com.example.factorisation.service.InvoiceItemsService;
import com.example.factorisation.service.PricelistItemsService;

import dto.GoodsOrServicesDTO;

public class GoodsOrServicesDTOtoGoodsOrServices  implements Converter<GoodsOrServicesDTO, GoodsOrServices>{

	@Autowired
	private GroupOfGoodsService groupOfGoodsService;
	
	@Override
	public GoodsOrServices convert(GoodsOrServicesDTO arg0) {
		
		GoodsOrServices g = new GoodsOrServices();
		
		g.setId(arg0.getId());
		g.setName(arg0.getName());
		g.setUnit(arg0.getUnit());
		
		GroupOfGoods groupOfGoods = groupOfGoodsService.findOne(arg0.getGroupOfGoodsId());
		if(groupOfGoods!=null) {
			g.setGroupOfGoods(groupOfGoods);
		}
		
		/*PricelistItems pricelistItems = PricelistItemsService.findOne(arg0.getPricelistItemsId());
		if(pricelistItems!=null) {
			g.setPricelistItems(pricelistItems);
		}
		
		InvoiceItems invoiceItems = InvoiceItemsService.findOne(arg0.getInvoiceItemsId());
		if(invoiceItems!=null) {
			g.setInvoiceItems(invoiceItems);
		}
		*/
		
		return g;
	}
}
