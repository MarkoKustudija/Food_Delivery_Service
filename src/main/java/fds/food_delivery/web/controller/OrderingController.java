package fds.food_delivery.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fds.food_delivery.model.Ordering;
import fds.food_delivery.service.OrderingService;
import fds.food_delivery.support.OrderingDtoToOrdering;
import fds.food_delivery.support.OrderingToOrderingDto;
import fds.food_delivery.web.dto.OrderingDto;

@RestController
@RequestMapping(value = "/api/orderings", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class OrderingController {
	
	@Autowired
	private OrderingService orderingService;
	@Autowired
	private OrderingDtoToOrdering toOrdering;
	@Autowired
	private OrderingToOrderingDto toDto;
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderingDto> getOne (@PathVariable Long id){
		
		Ordering ordering = orderingService.findOne(id);
		if(ordering != null) {
			return new ResponseEntity<OrderingDto>(toDto.convert(ordering), HttpStatus.OK);
		} else {
			return new ResponseEntity<OrderingDto>(HttpStatus.NOT_FOUND);
		}
	
	}
	
	@GetMapping
	public ResponseEntity<List<OrderingDto>> getAll (@RequestParam (required = false) Long id,
			@RequestParam(required = false, defaultValue = "0") int pageNo){
		
		Page<Ordering> pageOrdering;
		if(id != null) {
			pageOrdering = orderingService.search(id, pageNo);
		} else {
			pageOrdering = orderingService.findAll(PageRequest.of(pageNo, 4));
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Total-Pages", pageOrdering.getTotalPages() + "");
		
		return new ResponseEntity<>(toDto.convert(pageOrdering.getContent()), responseHeaders, HttpStatus.OK);
	}

	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderingDto> create (@RequestBody OrderingDto orderingDto){
		Ordering ordering = toOrdering.convert(orderingDto);
		Ordering savedOredering = orderingService.save(ordering);
		
		return new ResponseEntity<>(toDto.convert(savedOredering), HttpStatus.CREATED);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderingDto> update (@PathVariable Long id,@RequestBody OrderingDto orderingDto){
		
		if(!id.equals(orderingDto.getId())) {
			
			return new ResponseEntity<OrderingDto>(HttpStatus.BAD_REQUEST);
			
		}else {
			
			Ordering ordering = toOrdering.convert(orderingDto);
			Ordering changedOredering = orderingService.update(ordering);
			
			return new ResponseEntity<OrderingDto>(toDto.convert(changedOredering), HttpStatus.OK);
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<OrderingDto> delete (@PathVariable Long id){
		Ordering deleted = orderingService.delete(id);
		if(deleted == null) {
			return new ResponseEntity<OrderingDto>(HttpStatus.NOT_FOUND);
		}
		   return new ResponseEntity<OrderingDto>(toDto.convert(deleted), HttpStatus.OK);
		
	}
}
