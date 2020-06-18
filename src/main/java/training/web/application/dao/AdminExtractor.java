package training.web.application.dao;

import training.web.application.model.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Extractor of object for class {@link Admin} from database.
 * The pattern Template Method is used.
 * @author Ihor Savchenko
 */
public class AdminExtractor extends AbstractExtractor<Admin> {
    public Admin extract(ResultSet rs) throws SQLException {
        Admin admin = new Admin(rs.getInt("id"), rs.getString("login"), rs.getString("password"));
        return admin;
    }
}
