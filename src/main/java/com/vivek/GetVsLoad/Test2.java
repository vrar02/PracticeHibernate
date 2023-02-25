package com.vivek.GetVsLoad;


import com.vivek.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();



//        Student student1 = session.get(Student.class, 1);

        Student student1 = session.load(Student.class, 1);

        //In case of load select query will be initiated only when you fetch something from the
        //student1 object

        System.out.println(student1.getName()+"......"+student1.getCity());

        session.close();




    }
}
