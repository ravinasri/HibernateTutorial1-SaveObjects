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
		Stud s = new Stud();
		s.setRollno(1000);
		s.setName("Muruga");
		s.setMarks(98);

		Stud s1 = new Stud();
		s1.setRollno(2000);
		s1.setName("vinayaga");
		s1.setMarks(99);

		Stud s2 = new Stud();
		s2.setRollno(3000);
		s2.setName("soliyayi");
		s2.setMarks(100);

		Configuration c = new Configuration().configure().addAnnotatedClass(Stud.class);
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(c.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = c.buildSessionFactory(sr);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(s);
		session.save(s1);
		session.save(s2);
		tx.commit();
		//another way to save objects in session
		//session.beginTransaction();
		//session.save(s); //Saving the first UserInfoobject
		//session.save(s1); //Saving the second UserInfoobject
		//session.save(s2); 
		//session.getTransaction().commit();

		

		//Retrieving all the records of UserInfo
		Query query1 = session.createQuery("from Stud");
		List<Stud> collection1 =  query1.list();
		System.out.println("Retrieving and displaying details of all the users");
		for(Stud object : collection1)
		{
			System.out.println("Id : " + object.getRollno());
			System.out.println("First Name : " + object.getName());
			System.out.println("Last Name : " + object.getMarks());	
			System.out.println();
		}

	}
}


