package com.vivek.many2many_mapping;

import com.vivek.entities.Employee;
import com.vivek.entities.Gender;
import com.vivek.entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        //vivek works on ecommerce, painting projects in java tech
        //sai works on painting in java and webcrawl project in python tech

        Employee employee1=new Employee();
        employee1.setName("vivek");
        employee1.setId(111);
        employee1.setGender(Gender.MALE);

        Employee employee2=new Employee();
        employee2.setName("sai");
        employee2.setId(222);
        employee2.setGender(Gender.MALE);

        Project project1=new Project();
        project1.setId(1001);
        project1.setName("Ecommerce");
        project1.setTechnology("JAVA");

        Project project2=new Project();
        project2.setId(2002);
        project2.setName("Painting AUCTION");
        project2.setTechnology("JAVA");

        Project project3=new Project();
        project3.setId(3003);
        project3.setName("WEBCRAWL");
        project3.setTechnology("PYTHON");

        employee1.setProjectList(Arrays.asList(project1,project2));
        employee2.setProjectList(Arrays.asList(project2,project3));

////        We get two join tables because of just ManyToMany mapping on both entities..
////        table names are employees_projects, projects_employees
//          and corresponding tables are filled based on the list passed to it...here
//          it fills the employees_projects table and other is empty because for
//          any project we didnot set the employess list....

        //To fix the above issues..
        // ManyToMany mapping in both the entities...
        // and also set employee list for every project...
        // 1) We can use mappedBy in Project Entity and get only one table...but we dont have
        //control to change the column name in that join table...
        // 2) we need to use JoinTable annotation to have custom name for the join table....

        project1.setEmployeeList(Arrays.asList(employee1));
        project2.setEmployeeList(Arrays.asList(employee1,employee2));
        project3.setEmployeeList(Arrays.asList(employee2));

        session.save(employee1);
        session.save(employee2);
        session.save(project1);
        session.save(project2);
        session.save(project3);

        session.beginTransaction().commit();

        session.close();
        sessionFactory.close();

    }
}
