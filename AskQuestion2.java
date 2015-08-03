package com.example.user.funstion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Class that represents the second question in Funstion.
 *
 * Question involves waking up one day as a dog.
 *
 * @Author Anthony Chang
 * @Co-Author Jiajie Li
 * @version 1.0
 * @since 07-26-2015
 *
 */
public class AskQuestion2 extends AppCompatActivity implements View.OnClickListener{

    // Initiate variables
    Button bOptionA; // Buttons A through D
    Button bOptionB;
    Button bOptionC;
    Button bOptionD;

    TextView logOut; // Text link to log out and return to main screen.

    String userChose = ""; // Stores what the user chose
    int userLocation = 2; // Current location of the user in the list of questions.

    /**
     * Method that dictates what to do when an instance of this class is created.
     *
     * @param savedInstanceState (No idea what this is when I wrote this)
     * @return None
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question_2);

        bOptionA = (Button) findViewById(R.id.bOptionA);
        bOptionB = (Button) findViewById(R.id.bOptionB);
        bOptionC = (Button) findViewById(R.id.bOptionC);
        bOptionD = (Button) findViewById(R.id.bOptionD);

        logOut = (TextView) findViewById(R.id.tvLogOut);

        // Set click listeners
        bOptionA.setOnClickListener(this);
        bOptionB.setOnClickListener(this);
        bOptionC.setOnClickListener(this);
        bOptionD.setOnClickListener(this);

        logOut.setOnClickListener(this);
    }


    /**
     * Method that dictates what to do when a click/tap on the screen is "heard."
     *
     * @param v (No idea what v is at the time I wrote this)
     * @return None
     *
     */
    @Override
    public void onClick(View v) {

        // Four available answers
        if(v.getId() == R.id.bOptionA){
            userChose = "A";
            this.saveUserAnswer(userLocation, userChose);
        }

        if(v.getId() == R.id.bOptionB){
            userChose = "B";
            this.saveUserAnswer(userLocation, userChose);
        }

        if(v.getId() == R.id.bOptionC){
            userChose = "C";
            this.saveUserAnswer(userLocation, userChose);
        }

        if(v.getId() == R.id.bOptionC){
            userChose = "D";
            this.saveUserAnswer(userLocation, userChose);
        }

        if(v.getId() == R.id.tvLogOut){
            //Call something to save user's answers up to this point
            this.saveUserLocation(userLocation);
            startActivity(new Intent(this, Login.class));
        }
    }

    /**
     * Method to save the user's current location in the list of questions upon logout.
     *
     * @param currentLocation The question number that the user is on right now.
     * @return None
     *
     */
    private void saveUserLocation(int currentLocation){
        // Blank for now. Pass currentLocation on to another class that handles storing individual user data.
    }

    /**
     * Method to save what the user chose for this question.
     *
     * @param userLocation The question number for this answer.
     * @param userChose The answer that the user chose.
     *
     */
    private void saveUserAnswer(int userLocation, String userChose){
        // Blank for now. Pass userLocation and userChose on to another class that handles storing individual user data.
    }
}
