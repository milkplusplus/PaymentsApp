package paymentsystem.services;

import java.util.List;
import paymentsystem.models.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserServiceImpl implements UserService{
	
	public User findById(Long id) {
		SessionFactory sf = null;
		Session session = null;
		User user = null;
		
		try {			
			sf = new Configuration().configure().buildSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			user = (User) session.get(User.class, id);
	    	session.getTransaction().commit();
		} catch (RuntimeException e) {
			try {				
				session.getTransaction().rollback();
			} catch (RuntimeException rbe) {
				System.err.println("Couldn’t roll back transaction" + rbe);
			}
		} finally {
			if(session != null) {				
				session.close();
			}
			if(sf != null) {
				sf.close();	       				
			}
		}
		
		if(user == null) throw new RuntimeException("User not found");
		return user;
	}

	@Override
	//public void save(User user) {
		public void save() {
		
		SessionFactory sf = null;
		Session session = null;
		
		try {			
			sf = new Configuration().configure().buildSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
	    	User user = new User();
	    	user.setId(5L);
	    	user.setIsAdmin("admin");
	    	user.setLogin("lo");
	    	user.setPassword("pa");
	    	session.save(user);
	    	session.getTransaction().commit();
		} catch (RuntimeException e) {
			try {				
				session.getTransaction().rollback();
			} catch (RuntimeException rbe) {
				System.err.println("Couldn’t roll back transaction" + rbe);
			}
		} finally {
			if(session != null) {				
				session.close();
			}
			if(sf != null) {
				sf.close();	       				
			}
		}		
	}
	
	public void deleteById(Long id) {
		
		SessionFactory sf = null;
		Session session = null;
		
		try {			
			sf = new Configuration().configure().buildSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			User user = (User) session.get(User.class, id);
			session.delete(user);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			try {				
				session.getTransaction().rollback();
			} catch (RuntimeException rbe) {
				System.err.println("Couldn’t roll back transaction" + rbe);
			}
		} finally {
			if(session != null) {				
				session.close();
			}
			if(sf != null) {
				sf.close();	       				
			}
		}
		
	}
}
