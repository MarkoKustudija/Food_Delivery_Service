package fds.food_delivery.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fds.food_delivery.model.Bill;
import fds.food_delivery.service.BillService;
import fds.food_delivery.support.BillToBillDto;
import fds.food_delivery.web.dto.BillDto;

@RestController
@RequestMapping(value = "/api/bills", produces =  MediaType.APPLICATION_JSON_VALUE)
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private BillToBillDto toDto;
	
	@GetMapping
	public ResponseEntity<List<BillDto>> getAll(){
		
		List<Bill> bills = billService.findAll();
		return new ResponseEntity<>(toDto.convert(bills), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BillDto> getOne (@PathVariable Long id){
		Bill bill = billService.findOne(id);
		if(bill != null) {
			return new ResponseEntity<>(toDto.convert(bill), HttpStatus.OK);
		}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
	
	
}
