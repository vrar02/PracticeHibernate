package com.vivek.hql_queries;

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

        Student student=new Student();
        student.setName("ravi");
        student.setCity("arizona");

        Student student2=new Student();
        student2.setName("krishna");
        student2.setCity("california");

        session.save(student);
        session.save(student2);
        session.beginTransaction().commit();
        session.close();

        Session session1 = sessionFactory.openSession();

        String query="from Student as s where s.city=:p and s.name=:q";
        Query q = session1.createQuery(query);
        q.setParameter("p","arizona");
        q.setParameter("q","ravi");
        List<Student> list=q.list();
        for(Student st:list){
            System.out.println(st);
        }

        //for delete and update use q.executeUpdate();
        session1.close();


        //need to store

        sessionFactory.close();

    }
}
