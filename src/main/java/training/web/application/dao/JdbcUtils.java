package training.web.application.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class with utility methods for DAO layer.
 * @author Ihor Savchenko
 */
public final class JdbcUtils {
    public JdbcUtils() {
    }

    public static void closeQuietly(ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }
            catch (SQLException e){
                // NOP
            }
        }
    }

    public static void closeQuietly(Statement statement){
        if(statement != null){
            try{
                statement.close();
            }
            catch (SQLException e){
                // NOP
            }
        }
    }

    public static void closeQuietly(Connection connection){
        if(connection != null){
            try{
                connection.close();
            }
            catch (SQLException e){
                // NOP
            }
        }
    }

    public static void rollbackQuietly(Connection conn){
        if(conn != null){
            try{
                conn.rollback();
            }
            catch (SQLException e){
                // NOP
            }
        }
    }
}
