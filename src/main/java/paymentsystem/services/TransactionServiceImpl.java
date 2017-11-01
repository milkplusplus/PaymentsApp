package paymentsystem.services;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import paymentsystem.models.Transaction;
import paymentsystem.models.User;

public class TransactionServiceImpl implements TransactionService{

	@Override
	public List<Transaction> selectAll() {
		SessionFactory sf = null;
		Session session = null;
		List<Transaction> tr_list = new LinkedList<Transaction>();
		try {			
			sf = new Configuration().configure().buildSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Transaction");
			tr_list = q.list();
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
		return tr_list;
	}

}
