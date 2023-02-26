package com.vivek.pagenation;

import com.vivek.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        String query="from Student";
        Query query1 = session.createQuery(query);

        //before executing make sure you have data in student_info table...
        //import using the resources/student_info.csv file..to database..and set ddl.auto to update.


        //setting the begin row number to obtain..
        query1.setFirstResult(15);

        //setting to get only 10 rows every time..
        query1.setMaxResults(10);

        List<Student> list=query1.list();

        for(Student student:list){
            System.out.println(student);
        }

        session.close();
        sessionFactory.close();

    }
}
