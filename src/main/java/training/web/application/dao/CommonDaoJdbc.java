package training.web.application.dao;

import training.web.application.model.*;

import java.sql.*;
import java.util.List;
import java.util.Set;

/**
 * Implementation of the interface {@link CommonDao} for interacting with database
 * on behalf common users including Guest.
 * @author Ihor Savchenko
 */
public class CommonDaoJdbc extends AbstractDaoJdbc implements CommonDao {
    private static final String SELECT_ALL_ADMINS = "SELECT * FROM training_web_application.admins";
    private static final String SELECT_ALL_USERS = "SELECT * FROM training_web_application.users";
    private static final String SELECT_ADMIN = "SELECT * FROM training_web_application.admins AS AD WHERE AD.login = ? AND AD.password = ?";
    private static final String SELECT_USER = "SELECT * FROM training_web_application.users AS US WHERE US.login = ? AND US.password = ?";
    private static final String ADD_USER = "INSERT INTO training_web_application.users(login, password, name, lastname, email, access) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_ACCESS="UPDATE training_web_application.users AS US SET US.access=? WHERE US.id=?";
    private static final String DELETE_USER_BY_ID="DELETE FROM training_web_application.users AS US WHERE US.id=?";

    public Set<Admin> selectAllAdmins() throws DBSystemException, SQLException {
        Connection conn = getSerializableConnection();
        Statement statement = null;
        ResultSet rs = null;
        try{
            statement = conn.createStatement();
            rs = statement.executeQuery(SELECT_ALL_ADMINS);
            conn.commit();
            return new AdminExtractor().extractAll(rs);
        }
        catch(SQLException e){
            JdbcUtils.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '" + SELECT_ALL_ADMINS, e);
        }
        finally{
            JdbcUtils.closeQuietly(rs);
            JdbcUtils.closeQuietly(statement);
            JdbcUtils.closeQuietly(conn);
        }
    }

    public Admin selectAdmin(String login, String password) throws DBSystemException, SQLException {
        Connection conn = getSerializableConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            preparedStatement = conn.prepareStatement(SELECT_ADMIN);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            if(!rs.next()) return null;
            conn.commit();
            return new AdminExtractor().extract(rs);
        }
        catch(SQLException e){
            JdbcUtils.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '" + SELECT_ADMIN, e);
        }
        finally{
            JdbcUtils.closeQuietly(rs);
            JdbcUtils.closeQuietly(preparedStatement);
            JdbcUtils.closeQuietly(conn);
        }
    }

    public User selectUser(String login, String password) throws DBSystemException, SQLException {
        Connection conn = getSerializableConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            preparedStatement = conn.prepareStatement(SELECT_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            if(!rs.next()) return null;
            conn.commit();
            return new UserExtractor().extract(rs);
        }
        catch(SQLException e){
            JdbcUtils.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '" + SELECT_USER, e);
        }
        finally{
            JdbcUtils.closeQuietly(rs);
            JdbcUtils.closeQuietly(preparedStatement);
            JdbcUtils.closeQuietly(conn);
        }
    }

    public void addUser(String login, String password, String name, String lastname, String email) throws DBSystemException, SQLException {
        Connection conn = getSerializableConnection();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = conn.prepareStatement(ADD_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, lastname);
            preparedStatement.setString(5, email);
            preparedStatement.setBoolean(6, true);
            preparedStatement.executeUpdate();
            conn.commit();
        }
        catch(SQLException e){
            JdbcUtils.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '" + ADD_USER, e);
        }
        finally{
            JdbcUtils.closeQuietly(preparedStatement);
            JdbcUtils.closeQuietly(conn);
        }
    }

    public Set<User> selectAllUsers() throws DBSystemException, SQLException {
        Connection conn = getSerializableConnection();
        Statement statement = null;
        ResultSet rs = null;
        try{
            statement = conn.createStatement();
            rs = statement.executeQuery(SELECT_ALL_USERS);
            conn.commit();
            return new UserExtractor().extractAll(rs);
        }
        catch(SQLException e){
            JdbcUtils.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '" + SELECT_ALL_USERS, e);
        }
        finally{
            JdbcUtils.closeQuietly(rs);
            JdbcUtils.closeQuietly(statement);
            JdbcUtils.closeQuietly(conn);
        }
    }

    public void updateUserAccess(int id, boolean access) throws SQLException, DBSystemException {
        Connection conn=getSerializableConnection();
        PreparedStatement st=null;
        ResultSet rs=null;
        try {
            st=conn.prepareStatement(UPDATE_USER_ACCESS);
            st.setBoolean(1, access);
            st.setInt(2, id);
            st.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            JdbcUtils.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute UPDATE_USER_ACCESS",e);
        }finally {
            JdbcUtils.closeQuietly(st);
            JdbcUtils.closeQuietly(conn);
        }
    }

    public void deleteUserById(int id) throws SQLException, DBSystemException {
        Connection conn=getSerializableConnection();
        PreparedStatement st=null;
        try {
            st=conn.prepareStatement(DELETE_USER_BY_ID);
            st.setInt(1, id);
            st.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            JdbcUtils.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute UPDATE_USER_ACCESS",e);
        }finally {
            JdbcUtils.closeQuietly(st);
            JdbcUtils.closeQuietly(conn);
        }
    }
}
