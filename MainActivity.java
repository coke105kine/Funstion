package com.example.user.funstion;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    Button bContinue, bNewGame, bLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bContinue = (Button) findViewById(R.id.bContinue);
        bNewGame = (Button) findViewById(R.id.bNewGame);
        bLogout = (Button) findViewById(R.id.bLogout);

        bContinue.setOnClickListener(this);
        bNewGame.setOnClickListener(this);
        bLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogout: //if user selects log out
                startActivity(new Intent(this, Login.class)); //go to log in screen
                break;
        }
    }
}
