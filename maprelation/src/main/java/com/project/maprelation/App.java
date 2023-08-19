package com.project.maprelation;


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
        Student st = new Student();
        st.setRollno(1);
        st.setSname("mani");
        st.setMarks(95);
        
        Laptop lp = new Laptop();
        lp.setLid(10);
        lp.setLname("Hp");
        lp.getStudent().add(st);
        
        st.getLaptop().add(lp);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(lp);
        tx.commit();
    }
}
