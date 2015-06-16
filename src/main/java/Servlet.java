import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.session.SessionBean;
import org.hibernate.Session;

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
        Session session = new SessionBean().openSession();
        Object obj = session.get("user", 1);
        UserBean user = (UserBean) obj;
        response.getWriter().write(user.getPhone());
    }
}
