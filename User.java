package com.example.user.funstion;

/**
 * Created by User on 8/2/2015.
 */

//attributes of a new user
public class User {
    String firstName, lastName, username, password, passwordConfirm, email;

    public User (String firstName, String lastName, String username, String password, String passwordConfirm, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.email = email;
    }
}
