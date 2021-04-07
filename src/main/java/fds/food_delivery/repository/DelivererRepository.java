package fds.food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fds.food_delivery.model.Deliverer;
import fds.food_delivery.model.Ordering;

@Repository
public interface DelivererRepository extends JpaRepository<Deliverer, Long>{

	Deliverer findOneById(Long id);

	void save(Ordering order);

}
