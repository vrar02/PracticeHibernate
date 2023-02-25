package com.vivek.test_annotations;

import com.vivek.entities.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class Test1 {

    public static void main(String[] args) throws IOException {

        Configuration configuration=new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Address address=new Address();
        address.setCity("banglore");
        address.setDateCreated(new Date());
        address.setStreet("kormangala");
        address.setOpen(false);
        address.setX(12.314);

        FileInputStream fis=new FileInputStream("src/main/resources/passport.jpg");
        byte[] image=new byte[fis.available()];
        fis.read(image);
        address.setImage(image);


        session.save(address);
        session.beginTransaction().commit();
        session.close();
        sessionFactory.close();



    }
}
