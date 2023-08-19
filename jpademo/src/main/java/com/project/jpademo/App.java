package com.project.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
    	EntityManager em = emf.createEntityManager();
    	
    	em.getTransaction().begin();
    	Student st = new Student();
    	st.setS_id(1);
    	st.setS_name("Mani");
    	st.setS_age(23);
    	em.persist(st);
    	em.getTransaction().commit();
    }
}
