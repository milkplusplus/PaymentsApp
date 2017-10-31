package paymentsystem.services;

import java.util.List;
import paymentsystem.models.User;
//import paymentsystem.repositories.UserRepository;
import paymentsystem.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;


public class UserServiceImpl implements UserService{
	
//	private UserRepository userRepo;
	
//	public User findById(Long id) {
//		return userRepo.findUserById(id);
//		
//	}
	
	private UserRepository repo;
	public User findById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public void save(User user) {

	}
}
