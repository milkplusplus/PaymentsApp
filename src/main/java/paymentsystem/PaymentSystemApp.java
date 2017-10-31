package paymentsystem;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import paymentsystem.models.User;
import paymentsystem.services.UserService;
import paymentsystem.services.UserServiceImpl;

@SpringBootApplication
public class PaymentSystemApp {

    public static void main(String[] args) {
        SpringApplication.run(PaymentSystemApp.class, args);
    	
//    	SessionFactory sf = new Configuration().configure().buildSessionFactory();
//    	Session session = sf.openSession();
//    	session.beginTransaction();
//    	
////    	Query q = session.createQuery("from Transaction where client_id = 2");	
////    	UserService us = new UserServiceImpl();
////    	User user = us.findById((long) 3);
////    	List tr = q.list();
////    	session.getTransaction().commit();
//    	
//    	
//    	Long id = 3L;
//    	User user = (User) session.get(User.class, id); 	
//    	
//    	session.close();
//    	System.out.println(user.getLogin());
////    	System.out.println(tr.size());
//    	sf.close();
//    	
    }
}