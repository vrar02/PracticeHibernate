package com.vivek.hql_queries.joins;

import com.vivek.entities.Answer;
import com.vivek.entities.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Question question1=new Question();
        question1.setId(123);
        question1.setQues("What are the featueres of Hibernate?");

        Answer answer1=new Answer();
        answer1.setAns("Hibernate provides Query Language support...irrespective of DB");
        answer1.setId(101);
        answer1.setQuestion(question1);

        Answer answer2=new Answer();
        answer2.setId(102);
        answer2.setAns("Hibernate provides Caching, Object relational mapping support");
        answer2.setQuestion(question1);

        Answer answer3=new Answer();
        answer3.setId(103);
        answer3.setAns("Hibernate is light weight , exception handling support");
        answer3.setQuestion(question1);

        List<Answer> answerList=new ArrayList<>();
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);


        question1.setAnswerList(answerList);

        session.save(question1);
        session.save(answer1);
        session.save(answer2);
        session.save(answer3);


        session.beginTransaction().commit();
        session.close();


        //Here we perform join between question table and answers table...

        Session session1 = sessionFactory.openSession();
            //no need for on direction it is already linked.....
        String query="select q.id,q.ques, a.ans,a.id from Question as q INNER JOIN q.answerList as a";
        Query query1 = session1.createQuery(query);

        //each row is obtained as Object[] //need to use same in native sql queries as well..
        //in native query we use NativeQuery query1= session.createSQLQuery(query);

        List<Object[]> list=query1.list();

        for(Object[] obj:list){
            System.out.println("=================");
            System.out.println(obj[0]);
            System.out.println(obj[1]);
            System.out.println(obj[2]);
            System.out.println(obj[3]);
            System.out.println("=================");
        }

        session1.close();
        sessionFactory.close();
    }
}
