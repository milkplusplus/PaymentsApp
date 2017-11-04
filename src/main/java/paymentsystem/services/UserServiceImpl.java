package paymentsystem.services;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import paymentsystem.models.Transfer;
import paymentsystem.models.User;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserServiceImpl implements UserService{
	
	//private SessionFactory sf;
	
	public User findByLog(String log){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session sess = null;
		User user = null;
		
		try {	
			
			sess = sf.openSession();
			Transaction tx = null;
			
			try {
				tx = sess.beginTransaction();
				user = (User) sess.get(User.class, log);	
				tx.commit();				
			} catch(RuntimeException e2) {
				try {
					if(tx != null) tx.rollback();
				} catch (Exception e3) {
					throw new RuntimeException("Rollback error");
				}	
				throw new RuntimeException("Error while making query");
			}
			
		} catch (RuntimeException e1) {
			throw new RuntimeException(e1.getMessage());
		} finally {
			if(sess != null) sess.close();
		}
		
		if(user == null) throw new RuntimeException("User not found");
		return user;
		
	}

	@Override
	public void save(User user) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();		
		
		Session sess = null;
		
		try {	
			
			sess = sf.openSession();
			Transaction tx = null;
			
			try {
				tx = sess.beginTransaction();
				sess.save(user);	
				tx.commit();				
			} catch(RuntimeException e2) {
				try {
					if(tx != null) tx.rollback();
				} catch (Exception e3) {
					throw new RuntimeException("Rollback error");
				}				
				throw new RuntimeException("Error while performing transaction");
			}
			
		} catch (RuntimeException e1) {
			throw new RuntimeException(e1.getMessage());
		} finally {
			if(sess != null) sess.close();
		}
		
	}
	
	public void deleteById(Long id) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();		
		
		Session sess = null;
		
		try {	
			
			sess = sf.openSession();
			Transaction tx = null;
			
			try {
				tx = sess.beginTransaction();
				User user = (User) sess.get(User.class, id);
				sess.delete(user);	
				tx.commit();				
			} catch(RuntimeException e2) {
				try {
					if(tx != null) tx.rollback();
				} catch (Exception e3) {
					throw new RuntimeException("Rollback error");
				}				
				throw new RuntimeException("Error while performing transaction");
			}
			
		} catch (RuntimeException e1) {
			throw new RuntimeException(e1.getMessage());
		} finally {
			if(sess != null) sess.close();
		}
		
	}

	@Override
	public List<User> selectAll() {
	
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = null;
		List<User> us_list = new LinkedList<User>();
		
		try {			
			session = sf.openSession();
			Query q = session.createQuery("from User");
			us_list = q.list();
		} catch (RuntimeException e) {
			throw new RuntimeException("Error while transaction performing");
		} finally {
			if(session != null) {				
				session.close();
			}
		}
		
		return us_list;		
	}
}
