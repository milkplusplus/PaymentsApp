package paymentsystem.services;

import java.util.List;
import paymentsystem.models.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserServiceImpl implements UserService{
	
	public User findById(Long id) {
    	SessionFactory sf = new Configuration().configure().buildSessionFactory();
    	Session session = sf.openSession();
    	User user = (User) session.get(User.class, id); 
    	session.close();
    	sf.close();
    	return user;
	}

	@Override
	public void save(User user) {
			
	}
}
