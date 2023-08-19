
package com.project.lazyeger;



import java.util.Collection;

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
        
//        alien.setAid(3);
//        alien.setAname("rahul");
//        
//        lp.setLid(105);
//        lp.setBrand("vivo");
//        lp.setPrice(45);
//        lp.setAlien(alien);
        
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        //session.save(lp);
        //session.save(alien);
        
        Alien a1 = (Alien) session.get(Alien.class, 1);
        
        System.out.println(a1.getAname());
        
//        Collection<Laptop> laps = a1.getLaptops();
//        
//        for (Laptop l : laps)
//        {
//        	System.out.println(l);
//        }
        
        tx.commit();
    }
}
