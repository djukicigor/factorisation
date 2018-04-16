package converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.GroupOfGoods;
import dto.GroupOfGoodsDTO;

public class GroupOfGoodsToGroupOfGoodsDTO implements Converter<GroupOfGoods, GroupOfGoodsDTO>{
	
	@Override
	public GroupOfGoodsDTO convert(GroupOfGoods arg0) {
		
		GroupOfGoodsDTO g = new GroupOfGoodsDTO();
		
		g.setId(arg0.getId());
		g.setName(arg0.getName());
		g.setPercentage(arg0.getPercentage());
		
		if(arg0.getGoods_Or_Services() != null) {
			g.setGoodsOrServicesId(((GroupOfGoods) arg0.getGoods_Or_Services()).getId());
		}
		return g;
		
	}
	
	public List<GroupOfGoodsDTO> convert(List<GroupOfGoods> groupsOfGoods){
		
		List<GroupOfGoodsDTO> retVal = new ArrayList<GroupOfGoodsDTO>();
		
		for (GroupOfGoods groupOfGoods : groupsOfGoods) {
			retVal.add(convert(groupOfGoods));
		}
		
		return retVal;
	}
	
}
