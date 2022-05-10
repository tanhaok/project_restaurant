package model;

public class acc_model {
    private int id;
    private String username;
    private String password;
    private String usertype;

    //Constructor
    public acc_model(){}
    public acc_model(String username, String password, String usertype) {
        this.username = username;
        this.password = password;
        this.usertype = usertype;
    }

    public acc_model(int id, String username, String password, String usertype) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.usertype = usertype;
    }
    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return "acc_model{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usertype='" + usertype + '\'' +
                '}';
    }
}
