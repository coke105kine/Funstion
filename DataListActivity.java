package com.example.user.funstion;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

/**
* Class that iterates through the database to show the currently logged in user who else is registered locally.
*
* @Author Jiajie Li
* @Co-Author Anthony Chang
*
*/ 
public class DataListActivity extends AppCompatActivity {
    
    // Initiate variables
    ListView listView; // Instance of a class to display database data in a list format
    SQLiteDatabase sqLiteDatabase; // Instance of the SQLite database in use 
    UserDbHelper userDbHelper; // Instance of a helper class for the database
    Cursor cursor; // Instance of the cursor that will iterate through the database
    ListDataAdapter listDataAdapter; // Instance of the class that is also responsible for listing data

    /**
     * Method that dictates what to do when an instance of this class is created.
     * 
     * @param savedInstanceState The current state of the application?
     * @return None
     * 
     */
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layout);
        listView = (ListView)findViewById(R.id.list_view);
        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        cursor = userDbHelper.getInformation(sqLiteDatabase);
        //adds rows continuous
        if (cursor.moveToFirst()) {
            do {
                String username, password, email;
                username = cursor.getString(0);
                password = cursor.getString(1);
                email = cursor.getString(2);
                DataProvider dataProvider = new DataProvider(username, password, email);
                listDataAdapter.add(dataProvider);
            } while (cursor.moveToNext()); //moves to next row
        }
    }
}
