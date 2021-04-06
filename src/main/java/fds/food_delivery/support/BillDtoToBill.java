package fds.food_delivery.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fds.food_delivery.model.Bill;
import fds.food_delivery.web.dto.BillDto;

@Component
public class BillDtoToBill implements Converter<BillDto, Bill>{

	@Override
	public Bill convert(BillDto source) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
