
package com.ravina;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Stud s3 = new Stud();
		Configuration c = new Configuration().configure().addAnnotatedClass(Stud.class);
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(c.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = c.buildSessionFactory(sr);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		s3 = (Stud) session.get(Stud.class, 3000);
		tx.commit();
		System.out.println(s3);

		// Retrieving all the records of UserInfo
		Query query1 = session.createQuery("from Stud");
		List<Stud> collection1 = query1.list();
		System.out.println("Retrieving and displaying details of all the users");
		for (Stud object : collection1) {
			System.out.println("Id : " + object.getRollno());
			System.out.println("First Name : " + object.getName());
			System.out.println("Last Name : " + object.getMarks());
			System.out.println();
		}

	}
}
