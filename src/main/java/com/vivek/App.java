package com.vivek;

import com.vivek.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args ) {
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Student student=new Student();

        student.setId(112);
        student.setName("vivek");
        student.setCity("houston");
        System.out.println("Id: "+student.getId());


        Transaction transaction = session.beginTransaction();
        session.save(student);
        //as soon as the object is saved the id value is again set based on auto generated value...
        System.out.println("Id: "+student.getId());
        transaction.commit();

        session.close();
    }
}
