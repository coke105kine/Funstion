package com.example.user.funstion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener{

    Button bContinue, bNewGame, bLogout, bSeeDatabase;
    EditText etFirstName, etLastName, etUsername, etPassword, etPasswordConfirm, etEmail;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPasswordConfirm = (EditText) findViewById(R.id.etConfirmPassword);
        etEmail = (EditText) findViewById(R.id.etEmail);

        bContinue = (Button) findViewById(R.id.bContinue);
        bNewGame = (Button) findViewById(R.id.bNewGame);
        bLogout = (Button) findViewById(R.id.bLogout);
        bSeeDatabase = (Button) findViewById(R.id.bSeeDatabase);

        bContinue.setOnClickListener(this);
        bNewGame.setOnClickListener(this);
        bLogout.setOnClickListener(this);
        bSeeDatabase.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
    }
    //on startup
    @Override
    protected void onStart(){
        super.onStart();

        if (authenticate() == true){
            displayUserDetails();
        }
    }
    //confirms login
    private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();
    }
    //displasy user info
    private void displayUserDetails(){
        User user = userLocalStore.getLoggedInUser();

        etFirstName.setText(user.firstName);
        etLastName.setText(user.lastName);
        etUsername.setText(user.username);
        etPassword.setText(user.password);
        etPasswordConfirm.setText(user.passwordConfirm);
        etEmail.setText(user.email);
    }
    //logout and new game function
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogout: //if user selects log out
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);
                startActivity(new Intent(this, Login.class)); //go to log in screen
                break;
            case R.id.bNewGame: // If new game is clicked, go to first question.
                startActivity(new Intent(this, AskQuestion1.class));
                break;
        }
    }
}
