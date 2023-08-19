package com.project.DemoProject;

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
public class App 
{
    public static void main( String[] args )
    {
    	AlienName an = new AlienName();
    	
    	an.setFname("Navin");
    	an.setLname("Kumar");
    	an.setMname("friend");
    	
        Alien obj = new Alien();
        obj.setAid(101);
        obj.setColor("yellow");
        obj.setAname(an);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);   
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
       
        session.save(obj);
//        obj = (Alien) session.get(Alien.class, 101);
        
        tx.commit();
        System.out.println(obj);
    }
}
