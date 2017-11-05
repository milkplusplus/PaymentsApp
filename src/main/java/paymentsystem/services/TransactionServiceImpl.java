package paymentsystem.services;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import paymentsystem.models.Transfer;
import paymentsystem.models.User;

public class TransactionServiceImpl implements TransactionService{

	@Override
	public List<Transfer> selectAll(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = null;
		List<Transfer> tr_list = new LinkedList<Transfer>();
		try {			
			session = sf.openSession();
			Query q = session.createQuery("from Transfer where client_id = :id");
			q.setParameter("id", id);
			tr_list = q.list();
		} catch (RuntimeException e) {
			throw new RuntimeException("Error while transaction performing");
		} finally {
			if(session != null) {				
				session.close();
			}
		}
		return tr_list;
	}

}
