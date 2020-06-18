package training.web.application.filters;

import training.web.application.dao.CommonDao;
import training.web.application.dao.CommonDaoJdbc;
import training.web.application.dao.DBException;
import training.web.application.dao.DBSystemException;
import training.web.application.model.Admin;
import training.web.application.model.User;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by Adnmin on 4/15/2019.
 */
public class SearchMatchFilter extends BaseFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException, DBException {

        CommonDao commonDao = new CommonDaoJdbc();
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        Boolean match = false;

        try {
            Set<User> users = commonDao.selectAllUsers();
            for (User user: users) {
                if(user.getLogin().equals(login) || user.getEmail().equals(email)){
                    match = true;
                    break;
                }
            }
            Set<Admin> admins = commonDao.selectAllAdmins();
            for (Admin admin: admins) {
                if(admin.getLogin().equals(login)){
                    match = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Reading of all users from data base", e);
        }

        if(match){
            req.setAttribute("matchUser", true);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/registration.jsp");
            dispatcher.forward(req, resp);
        }
        else filterChain.doFilter(req, resp);

    }
}
