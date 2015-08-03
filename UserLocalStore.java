package com.example.user.funstion;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by User on 8/2/2015.
 */
public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("firstName", user.firstName);
        spEditor.putString("lastName", user.lastName);
        spEditor.putString("username", user.username);
        spEditor.putString("password", user.password);
        spEditor.putString("passwordConfirm", user.passwordConfirm);
        spEditor.putString("email", user.email);
        spEditor.commit();
    }

    public User getLoggedInUser(){
        String firstName = userLocalDatabase.getString("firstName", "");
        String lastName = userLocalDatabase.getString("lastName", "");
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");
        String passwordConfirm = userLocalDatabase.getString("passwordConfirm", "");
        String email = userLocalDatabase.getString("email", "");
        User storedUser = new User(firstName, lastName, username, password, passwordConfirm, email);
        return storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("LoggedIn", loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){
        if (userLocalDatabase.getBoolean("loggedIn", false) == true){
            return true;
        }
        else{
            return false;
        }
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
