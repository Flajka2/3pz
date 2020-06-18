package training.web.application.dao;

/**
 * Own Exception superclass for intercept exceptional situations while interacting with database.
 * @author Ihor Savchenko
 */
public class DBException extends RuntimeException {
    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}
