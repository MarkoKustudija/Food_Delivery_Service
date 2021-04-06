package fds.food_delivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fds.food_delivery.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	Order findOneById(Long id);

	Optional<Order> one(Long id);

	List<Order> findByIdIn(List<Long> ids);

	Page<Order> search(Long id, PageRequest of);

}
