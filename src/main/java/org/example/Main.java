package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person =  session.find(Person.class, 1);
            Item item = new Item(person, "Honda Stepwgn");
            session.persist(item);

            Thread.sleep(5000);
            System.out.println(person.getItems());

            session.getTransaction().commit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Приложение завершено");
    }
}