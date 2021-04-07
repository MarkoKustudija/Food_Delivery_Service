package fds.food_delivery.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fds.food_delivery.model.Ordering;
import fds.food_delivery.service.BillService;
import fds.food_delivery.service.DelivererService;
import fds.food_delivery.service.OrderingService;
import fds.food_delivery.web.dto.OrderingDto;

@Component
public class OrderingDtoToOrdering implements Converter<OrderingDto, Ordering>{
	
	@Autowired
	private OrderingService orderingService;
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private DelivererService delivererService;

	@Override
	public Ordering convert(OrderingDto source) {
		Ordering ordering = null;
		if(source.getId() == null) {
			ordering = new Ordering();
		} else {
			ordering = orderingService.findOne(source.getId());
		}
		if(ordering != null) {
			ordering.setId(source.getId());
			ordering.setOrderDate(getLocalDateTime(source.getOrderDate()));
			ordering.setOrderNumber(source.getOrderNumber());
			ordering.setPrice(source.getPrice());
			ordering.setDescription(source.getDescription());
			ordering.setDeliveryAddress(source.getDeliveryAddress());
			
			ordering.setBill(billService.findOne(source.getBillId()));
			ordering.setDeliverer(delivererService.findOne(source.getDelivererId()));
			
		
		}
		return ordering;
	}

	private LocalDateTime getLocalDateTime(String dateAndTime)  throws DateTimeParseException{
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateAndTime.substring(0, 10), formatter);
        LocalTime time = LocalTime.parse(dateAndTime.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
        return LocalDateTime.of(date, time);
		
	}
	

}
