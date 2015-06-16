package edu.fudan.hangout.test;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.dao.impl.UserDaoImpl;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by Tong on 06.16.
 */
public class TestLogin extends HibernateDaoSupport {
    public static void main(String[] args) {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        UserBean userBean = userDaoImpl.getUserById("1");
        System.out.println(userBean.getUsername());
    }
}