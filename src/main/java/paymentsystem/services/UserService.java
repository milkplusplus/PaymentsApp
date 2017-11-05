package paymentsystem.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import paymentsystem.models.User;

public interface UserService {
	User findByLog(String log);
	User findById(long id);
    void save(User user);
    //void save();
	void deleteById(Long id);
	List<User> selectAll();

}

