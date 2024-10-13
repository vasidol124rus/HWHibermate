package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Db {
    public static final String URL = "jdbc:mysql://localhost:3306";
    public static final String USER = "root";
    public static final String PASSWORD = "Gbplf_1317";

    public static void connector() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory sf = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
        Session session = sf.openSession();
        Person person = new Person("Лумумба", 30);
        Person person1 = new Person("Вассерман", 45);

        session.beginTransaction();
        session.save(person);
        session.save(person1);
        session.getTransaction().commit();
        session.close();
    }


}