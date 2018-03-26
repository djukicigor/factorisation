package converter;

import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.GroupOfGoods;

import dto.GroupOfGoodsDTO;

public class GroupOfGoodsDTOtoGroupOfGoods implements Converter<GroupOfGoodsDTO, GroupOfGoods>{
	
	@Override
	public GroupOfGoods convert(GroupOfGoodsDTO arg0) {
		
		GroupOfGoods g = new GroupOfGoods();
		
		g.setId(arg0.getId());
		g.setName(arg0.getName());
		g.setPercentage(arg0.getPercentage());
		
		return g;
		
	}

}
