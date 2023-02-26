package com.vivek.hibernate_states;

import com.vivek.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Student student=new Student();
        student.setName("reddy");
        student.setCity("kurnool");
        //When object is newly created then it is in transient state..
        session.save(student);
        //when the object is saved it is in persistent state...
        //ie. any changes to object properties will reflect in db directly..
        student.setCity("hyderabad");
        session.beginTransaction().commit();
        student.setCity("vizag");
        session.beginTransaction().commit();
        //after detach() the object is in detached state...which is same as transient state..
        session.detach(student);
        student.setCity("map2"); //this wont update the current student present in database...instead new object is added in db when save is called
        session.save(student);
        session.beginTransaction().commit();

        session.remove(student); //This is used to  remove the student object after commit from database..here removes map2 from database...
        //The above line basically removes the student from the session and any associated transaction
        // and also database so that it cannot be saved again in this session unless you begin a new transaction before saving to this session again.
        //so line 37 and 39 was required
        student.setCity("nellore");
//      Transaction transaction = session.beginTransaction();
        session.save(student); //This was throwing the exception "no transaction is in progress"..so new transaction is required before this..
//      transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
