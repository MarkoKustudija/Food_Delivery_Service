package fds.food_delivery.support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fds.food_delivery.model.Deliverer;
import fds.food_delivery.model.Ordering;
import fds.food_delivery.web.dto.DelivererDto;

@Component
public class DelivererToDelivererDto implements Converter<Deliverer, DelivererDto>{
	

	@Autowired
	private OrderingToOrderingDto toDto;

	@Override
	public DelivererDto convert(Deliverer source) {
		DelivererDto dto = new DelivererDto();
		dto.setId(source.getId());
		dto.setIdNumber(source.getIdNumber());
		dto.setNameSurname(source.getNameSurname());
		dto.setPersonalNumber(source.getPersonalNumber());
		
		List<Ordering> orders = new ArrayList<>(source.getOrders());
		dto.setOrders(new HashSet<>(toDto.convert(orders)));
		
		return dto;
	}
	
	public List<DelivererDto> convert (List<Deliverer> deliverers){
		List<DelivererDto> delivererDtos = new ArrayList<>();
		for(Deliverer d : deliverers) {
			delivererDtos.add(convert(d));
		}
		return delivererDtos;
		
	}
	
	
	
	
	

}
