package com.example.factorisation.converter;

import org.springframework.core.convert.converter.Converter;

import com.example.factorisation.model.GoodsOrServices;
import com.example.factorisation.model.GroupOfGoods;
import com.example.factorisation.service.GoodsOrServicesService;

import dto.GroupOfGoodsDTO;

public class GroupOfGoodsDTOtoGroupOfGoods implements Converter<GroupOfGoodsDTO, GroupOfGoods>{
	
	@Override
	public GroupOfGoods convert(GroupOfGoodsDTO arg0) {
		
		GroupOfGoods g = new GroupOfGoods();
		
		g.setId(arg0.getId());
		g.setName(arg0.getName());
		g.setPercentage(arg0.getPercentage());
		
		/*GoodsOrServices goodsOrServices = GoodsOrServicesService.findOne(arg0.getGoodsOrServicesId());
		if(goodsOrServices!=null) {
			g.setGoodsOrServices(goodsOrServices);
		}
		*/
		return g;
		
	}

}
