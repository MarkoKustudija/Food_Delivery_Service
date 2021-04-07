package fds.food_delivery.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fds.food_delivery.model.Bill;
import fds.food_delivery.web.dto.BillDto;

@Component
public class BillToBillDto implements Converter<Bill, BillDto> {

	@Override
	public BillDto convert(Bill source) {
		BillDto billDto = new BillDto();
		billDto.setId(source.getId());
		billDto.setDate(source.getDate().toString());
		billDto.setBillNumber(source.getBillNumber());
		billDto.setPrice(source.getPrice());
		//billDto.setOrderingId(source.getOrdering().getId());
		
		return billDto;
	}
	
	public List<BillDto> convert (List<Bill> bills){
		List<BillDto> billDtos = new ArrayList<>();
		for(Bill b : bills) {
			billDtos.add(convert(b));
		}
		return billDtos;
		
	}
	

}
