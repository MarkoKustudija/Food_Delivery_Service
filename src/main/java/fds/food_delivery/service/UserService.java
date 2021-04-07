package fds.food_delivery.service;

import org.springframework.data.domain.Page;

import fds.food_delivery.model.User;
import fds.food_delivery.web.dto.UserPasswordChangeDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> one(Long id);

    List<User> all();

    Page<User> all(int pageNo);

    User save(User user);

    void delete(Long id);

    Optional<User> findbyUserName(String username);

	boolean changePassword(Long id, UserPasswordChangeDto userPasswordChangeDto);
}
