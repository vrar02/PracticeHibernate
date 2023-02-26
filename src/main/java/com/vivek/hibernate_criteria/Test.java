package com.vivek.hibernate_criteria;

import com.vivek.entities.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


public class Test {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();



//        Criteria criteria = session.createCriteria(Student.class);
//        criteria.add(Restrictions.like("city","%South%"));
//        List<Student> studentList=criteria.list();
//
//        for(Student student:studentList){
//            System.out.println(student);
//        }


        /* using javax persistance apis */
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.select(root);
        //criteriaQuery.where(criteriaBuilder.equal(root.get("city"),"South Shannonville"));

        criteriaQuery.where(criteriaBuilder.like(root.<String>get("city"),"%South%"));

        Query<Student> query = session.createQuery(criteriaQuery);
        List<Student> studentList=query.list();

        for(Student student:studentList){
            System.out.println(student);
        }

        session.close();
        sessionFactory.close();


    }
}
