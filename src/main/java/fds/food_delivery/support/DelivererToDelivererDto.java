package fds.food_delivery.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fds.food_delivery.model.Deliverer;
import fds.food_delivery.web.dto.DelivererDto;

@Component
public class DelivererToDelivererDto implements Converter<Deliverer, DelivererDto>{

	@Override
	public DelivererDto convert(Deliverer source) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
