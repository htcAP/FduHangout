package edu.fudan.hangout.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 * Created by Tong on 06.17.
 */
public class MySessionFactory {
    private static SessionFactory factory;

    private MySessionFactory() {

    }

    public static SessionFactory getFactory() {
        if (factory == null) {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            factory = configuration.buildSessionFactory(ssrb.build());
//            SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        return factory;
    }
}
