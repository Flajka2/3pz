package training.web.application.dao;

import training.web.application.model.Admin;
import training.web.application.model.User;

import java.sql.SQLException;
import java.util.Set;

/**
 * Interface for interacting with database on behalf common users including Guest.
 * @author Ihor Savchenko
 */
public interface CommonDao {
    Set<Admin> selectAllAdmins() throws DBSystemException, SQLException;

    Set<User> selectAllUsers() throws DBSystemException, SQLException;

    Admin selectAdmin(String login, String password) throws DBSystemException, SQLException;

    User selectUser(String login, String password) throws DBSystemException, SQLException;

    void addUser(String login, String password, String name, String lastname, String email) throws DBSystemException, SQLException;

    void updateUserAccess(int id, boolean access) throws SQLException, DBSystemException;

    public void deleteUserById(int id) throws SQLException, DBSystemException;
}
