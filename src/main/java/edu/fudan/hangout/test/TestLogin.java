package edu.fudan.hangout.test;

import edu.fudan.hangout.bean.UserBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * Created by Tong on 06.16.
 */
public class TestLogin extends HibernateDaoSupport {

    private static SessionFactory factory;

    public static void main(String[] args) {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        UserBean userBean = (UserBean) session.get("edu.fudan.hangout.bean.UserLogBean", 1);
        System.out.println(userBean.getUsername());
    }
}