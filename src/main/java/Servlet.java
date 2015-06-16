import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.dao.UserDao;
import edu.fudan.hangout.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tong on 06.16.
 */

public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDaoImpl();
        UserBean userBean = userDao.getUserById(1);
        response.getWriter().write(userBean.getPhone());
    }
}
