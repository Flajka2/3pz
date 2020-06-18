package training.web.application.servlets;

import training.web.application.dao.CommonDao;
import training.web.application.dao.CommonDaoJdbc;
import training.web.application.dao.DBException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * The Servlet that blocks or unblocks of users.
 * @author Ihor Savchenko
 */
public class SetUserAccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CommonDao commonDao = new CommonDaoJdbc();

        try {
            commonDao.updateUserAccess(Integer.parseInt(req.getParameter("id_user")),
                    Boolean.parseBoolean(req.getParameter("access")));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Update user's access by id is failed", e);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(String.
                format("%s%s", req.getContextPath(), "/enterAdmin"));
        requestDispatcher.forward(req, resp);
    }
}
