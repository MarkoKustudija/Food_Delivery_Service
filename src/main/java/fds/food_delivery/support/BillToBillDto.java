package fds.food_delivery.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fds.food_delivery.model.Bill;
import fds.food_delivery.web.dto.BillDto;

@Component
public class BillToBillDto implements Converter<Bill, BillDto> {

	@Override
	public BillDto convert(Bill source) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
