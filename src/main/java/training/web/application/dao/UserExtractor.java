package training.web.application.dao;

import training.web.application.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Extractor of object for class {@link User} from database.
 * The pattern Template Method is used.
 * @author Ihor Savchenko
 */
public class UserExtractor extends AbstractExtractor<User> {
    public User extract(ResultSet rs) throws SQLException {
        User user = new User(rs.getInt("id"), rs.getString("login"),
                rs.getString("password"), rs.getString("name"), rs.getString("lastname"),
                rs.getString("email"), rs.getBoolean("access"));
        return user;
    }
}
