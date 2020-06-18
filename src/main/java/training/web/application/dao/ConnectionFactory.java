package training.web.application.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interface to get the Connection from Connection Pool {@link ConnectionPool_Derby}.
 * @author Ihor Savchenko
 */
public interface ConnectionFactory {
    Connection newConnection() throws SQLException;
}
