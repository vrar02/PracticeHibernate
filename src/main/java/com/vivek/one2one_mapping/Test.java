package com.vivek.one2one_mapping;

import com.vivek.entities.Gender;
import com.vivek.entities.Vote;
import com.vivek.entities.Voter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Voter voter=new Voter();
        voter.setId(102);
        voter.setName("pragna");
        voter.setGender(Gender.FEMALE);


        Vote vote=new Vote();
        vote.setId(1004);
        vote.setPartyName("Janasena");
        vote.setWardName("DSNR");
        vote.setVoter(voter);

        voter.setVote(vote);

//        session.save(voter);
        session.save(vote);
        session.save(voter);

        session.beginTransaction().commit();

        session.close();
        sessionFactory.close();


    }
}
