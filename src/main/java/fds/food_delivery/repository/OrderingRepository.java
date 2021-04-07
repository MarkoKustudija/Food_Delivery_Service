package fds.food_delivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fds.food_delivery.model.Ordering;

@Repository
public interface OrderingRepository extends JpaRepository<Ordering, Long>{

	Ordering findOneById(Long id);

	//Optional<Orders> one(Long id);

	List<Ordering> findByIdIn(List<Long> ids);
	
	@Query("SELECT o FROM Ordering o WHERE : orderingId = NULL OR o.id = :orderingId")
	Page<Ordering> search(@Param("orderingId") Long orderingId, Pageable pageable);

}
