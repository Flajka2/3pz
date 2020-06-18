package training.web.application.model;

/**
 * Model class for {@link Role#Admin}.
 * @author Ihor Savchenko
 */
public class Admin implements Comparable<Admin> {
    private final int id;
    private String login;
    private String password;

    public Admin(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int compareTo(Admin admin) {
        if(this.getLogin().compareTo(admin.getLogin()) < 0)
            return -1;
        else if(this.getLogin().compareTo(admin.getLogin()) > 0)
            return 1;
        else return 0;
    }
}
