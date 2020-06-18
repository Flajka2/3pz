package training.web.application.dao;

/**
 * Own Exception class for intercept exceptional situations while interacting with database.
 * @author Ihor Savchenko
 */
public class DBSystemException extends DBException {
    public DBSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
