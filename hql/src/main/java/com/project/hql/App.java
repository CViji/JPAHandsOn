package com.project.hql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);   
        Session session = sf.openSession();
        int b=50;
        session.beginTransaction();
        
//        Query q = session.createQuery("from Student");
//        List<Student> students = q.list();
//        for (Student st : students)
//        {
//        	System.out.println(st);
//        }
        
//        Query q = session.createQuery("from Student where rollno=4");
//        Student student =  (Student) q.uniqueResult();
//        System.out.println(student);
      
//        Query q = session.createQuery("select rollno,name,marks from Student where rollno=4");
//        Object[] student = (Object[]) q.uniqueResult();
//        System.out.println(student[0] + " " + student[1] + " " + student[2]);
//        for (Object o : student)
//        {
//        	System.out.println(o);
//        }
        
//        Query q = session.createQuery("select rollno,name,marks from Student where marks>50");
//        List<Object[]> students = (List<Object[]>) q.list();
//        for (Object[] student : students)
//        {
//        	System.out.println(student[0] + " " + student[1] + " " + student[2] );
//        }
        
//        Query q = session.createQuery("select sum(marks) from Student s where s.marks>60");
//        Long marks = (Long) q.uniqueResult();
//        System.out.println(marks);
        
////        Query q = session.createQuery("select sum(marks) from Student s where s.marks>"+b);
//        Query q = session.createQuery("select sum(marks) from Student s where s.marks> :b");
//        q.setParameter("b", b); //Positional Parameter in JDBC
//        Long marks = (Long) q.uniqueResult();
//        System.out.println(marks);
        
    /** Using SQL in Hibernate **/      
        
//        SQLQuery query = session.createSQLQuery("select * from student where marks>60");
//        query.addEntity(Student.class);
//        List<Student> students = query.list();
//        for (Student s : students)
//        {
//        	System.out.println(s);
//        }
        
        // Native Queries....
        SQLQuery query = session.createSQLQuery("select name,marks from student where marks>60");
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<Student> students = query.list();
        
        for(Object o : students)
        {
        	Map m = (Map) o;
        	System.out.println(m.get("name") + " : " + m.get("marks"));
        }
        session.getTransaction().commit();
        
    }
}
