package com.example.user.funstion;

/**
 * Created by User on 8/2/2015.
 */
public class DataProvider {

    private String username;
    private String password;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DataProvider(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;


    }
}
