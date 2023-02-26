package com.vivek.second_level_caching;

import com.vivek.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Student student1 = session.get(Student.class, 35);
        System.out.println(student1);
        //only once the select statement will be called for same id..within the same session..
        //default first level caching provided by the session object of hibernate
        System.out.println("*********88working********");
        Student student2 = session.get(Student.class, 35);

        System.out.println(student2);

        session.close();
        Session session1 = sessionFactory.openSession();
        //even after session closing the select is not called...object is fetched from the second level cache....
        Student student3 = session1.get(Student.class, 35);
        System.out.println(student3);
        session1.close();
        sessionFactory.close();
    }

}
