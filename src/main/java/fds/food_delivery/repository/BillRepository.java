package fds.food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fds.food_delivery.model.Bill;
import fds.food_delivery.model.Order;

@Repository
public interface BillRepository  extends JpaRepository<Bill, Long> {

	Bill findOneById(Long id);

	void save(Order order);
	

}
