package training.web.application.servlets;

import training.web.application.dao.CommonDao;
import training.web.application.dao.CommonDaoJdbc;
import training.web.application.dao.DBException;
import training.web.application.model.Admin;
import training.web.application.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

/**
 * The Servlet that handles the entering user in your personal cabinet.
 * @author Ihor Savchenko
 */
public class EnterAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        CommonDao commonDao = new CommonDaoJdbc();

        try {
            Set<User> users= commonDao.selectAllUsers();
            if(users != null) session.setAttribute("allUsers", users);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Select user by login and password from data base is failed", e);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/AdminCabinet.jsp");
        requestDispatcher.forward(req, resp);
    }
}
