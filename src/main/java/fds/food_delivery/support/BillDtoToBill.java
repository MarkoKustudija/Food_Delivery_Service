package fds.food_delivery.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fds.food_delivery.model.Bill;
import fds.food_delivery.service.BillService;
import fds.food_delivery.service.OrderingService;
import fds.food_delivery.web.dto.BillDto;

@Component
public class BillDtoToBill implements Converter<BillDto, Bill>{
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private OrderingService orderingService;

	@Override
	public Bill convert(BillDto source) {
        Bill bill = null;
        if(source.getId() == null) {
        	bill = new Bill();
        } else {
        	bill = billService.findOne(source.getId());
        }
        if(bill != null) {
        	bill.setId(source.getId());
        	bill.setBillNumber(source.getBillNumber());
        	bill.setDate(getLocalDateTime(source.getDate()));
        	bill.setPrice(source.getPrice()); 
        //	bill.setOrdering(orderingService.findOne(source.getOrderingId()));
        	
        }
		return bill;
	}

	private LocalDateTime getLocalDateTime(String dateAndTime) throws DateTimeParseException {
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate date = LocalDate.parse(dateAndTime.substring(0, 10), formatter);
	        LocalTime time = LocalTime.parse(dateAndTime.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
	        return LocalDateTime.of(date, time);
		
	}

}
