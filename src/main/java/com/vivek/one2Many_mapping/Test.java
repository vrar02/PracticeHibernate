package com.vivek.one2Many_mapping;

import com.vivek.entities.Answer;
import com.vivek.entities.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
        sessionFactory.close();

    }
}
