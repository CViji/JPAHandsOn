package com.project.cache;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
		
		//Make sure hibernate version is same working in pom.xml
    	Alien a = null;
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);   
        Session session = sf.openSession();
        Session session1 = sf.openSession();
        
//        session.beginTransaction();
//        a = (Alien) session.get(Alien.class,1);
//        System.out.println(a);
//        session.getTransaction().commit();
//        session.close();
//        
//        session1.beginTransaction();
//        a = (Alien) session1.get(Alien.class,1);
//        System.out.println(a);
//        session1.getTransaction().commit();
//        session1.close();
        
        // Using Query 
        session.beginTransaction();
        Query q1 = session.createQuery("from Alien where aid=1");
        q1.setCacheable(true);
        a = (Alien) q1.uniqueResult();
        System.out.println(a);
        session.getTransaction().commit();
        session.close();
        
        session1.beginTransaction();
        Query q2 = session1.createQuery("from Alien where aid=1");
        q2.setCacheable(true);
        a = (Alien) q2.uniqueResult();
        System.out.println(a);
        session1.getTransaction().commit();
        session1.close();
        
    }
}
