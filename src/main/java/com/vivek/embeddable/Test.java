package com.vivek.embeddable;

import com.vivek.entities.Certificate;
import com.vivek.entities.StudentCert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        StudentCert studentCert=new StudentCert();
        Certificate certificate=new Certificate();
        certificate.setCourse("computer science");
        certificate.setResult("DISTINCTION");

        studentCert.setId(200023);
        studentCert.setName("vivek");
        studentCert.setCert(certificate);
        
        session.save(studentCert);

        session.beginTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
