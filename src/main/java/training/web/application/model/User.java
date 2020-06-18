package training.web.application.model;

public class User implements Comparable<User> {
    private int id;
    private String login;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private Boolean access;

    public User(int id,String login,String password,String name,String lastname,String email,Boolean access){
        this.id=id;
        this.login=login;
        this.password=password;
        this.name=name;
        this.lastname=lastname;
        this.email=email;
        this.access=access;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public Boolean getAccess(){
        return access;
    }

    public void setAccess(Boolean access){
        this.access=access;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login=login;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname=lastname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public int compareTo(User user){
        if(this.getLastname().compareTo(user.getLastname())<0)
            return -1;
        else if(this.getLastname().compareTo(user.getLastname())>0)
            return 1;
        else if(this.getName().compareTo(user.getName())<0)
            return -1;
        else if(this.getName().compareTo(user.getName())>0)
            return 1;
        else return 0;
    }
}