package com.example.user.funstion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends AppCompatActivity implements View.OnClickListener{

    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername); //looks for field with id etUsername and assigns it to etUsername
        etPassword = (EditText) findViewById(R.id.etPassword); //looks for field with id etPassword and assigns it to etPassword
        bLogin = (Button) findViewById(R.id.bLogin); //looks for field with id bLogin and assigns it to bLogin
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);

        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
    }

    @Override //when login button is clicked, this method will be notified
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogin: //when login button is clicked
                break;
            case R.id.tvRegisterLink: //when register link is clicked
                startActivity(new Intent(this, Register.class));
                break;
        }
    }
}
