package training.web.application.dao;

import org.apache.derby.jdbc.EmbeddedConnectionPoolDataSource;
import training.web.application.service.Settings;

import javax.sql.ConnectionPoolDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Standard Connection Pool for DAO layer and the case using Apache Derby database.
 * The pattern Singleton is used.
 * @author Ihor Savchenko
 */
public class ConnectionPool_Derby implements ConnectionFactory {
    ConnectionPoolDataSource dataSource;
    private final Settings SETTINGS = Settings.getInstance().getInstance();

    public Connection newConnection() throws SQLException {
        return dataSource.getPooledConnection().getConnection();
    }

    public ConnectionPool_Derby() {
        EmbeddedConnectionPoolDataSource connectionPool = new EmbeddedConnectionPoolDataSource();
        connectionPool.setDatabaseName(SETTINGS.value("databaseName"));
        this.dataSource = connectionPool;
    }
}
