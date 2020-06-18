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

/**
 * The Servlet that verify user data.
 * @author Ihor Savchenko
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        CommonDao commonDao = new CommonDaoJdbc();
        User user = null;
        Admin admin = null;

        try {
            user = commonDao.selectUser(login, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Select user by login and password from data base is failed", e);
        }

        if(user != null){
            session.setAttribute("user", user);
            resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/enter"));
        }
        else {
            try {
                admin = commonDao.selectAdmin(login, password);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new DBException("Select user by login and password from data base is failed", e);
            }

            if (admin != null) {
                session.setAttribute("admin", admin);
                resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/enterAdmin"));
            } else {
                req.setAttribute("incorrectLogin", true);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
                dispatcher.forward(req, resp);
            }
        }
    }
}
