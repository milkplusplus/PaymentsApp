package paymentsystem.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import paymentsystem.models.User;

public interface UserService {
	User findById(Long id);

    void save(User user);

}

