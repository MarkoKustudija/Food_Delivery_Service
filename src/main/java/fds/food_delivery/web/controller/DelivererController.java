package fds.food_delivery.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fds.food_delivery.model.Deliverer;
import fds.food_delivery.service.DelivererService;
import fds.food_delivery.support.DelivererToDelivererDto;
import fds.food_delivery.web.dto.DelivererDto;

@RestController
@RequestMapping(value = "/api/deliverers", produces = MediaType.APPLICATION_JSON_VALUE)
public class DelivererController {
	
	@Autowired
	private DelivererService delivererService;
	
	@Autowired
	private DelivererToDelivererDto toDto;
	
	@GetMapping
	public ResponseEntity<List<DelivererDto>> getAll(){
		List<Deliverer> deliverers = delivererService.findAll();
		return new ResponseEntity<>(toDto.convert(deliverers), HttpStatus.OK);
	}

}
