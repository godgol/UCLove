package com.example.christophe.uclove;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Text;

/**
 * Created by antoine on 04/05/16.
 */
public class FriendPanelActivity extends AppCompatActivity {



    TextView login_value = null;
    TextView age_value= null;
    TextView hair_value = null;
    TextView gender_value = null;
    TextView location_value = null;
    TextView inclination_value = null;
    String friend;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_friendpanel);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
             friend = extras.getString("friend");
        }
        DatabaseHandler2 db = new DatabaseHandler2(FriendPanelActivity.this);
        login_value =  (TextView) findViewById(R.id.name_value);
        login_value.setText(friend);

        age_value = (TextView) findViewById(R.id.age_value);
        age_value.setText(String.valueOf(db.readAge(friend)));

        hair_value = (TextView) findViewById(R.id.hair_value);
        hair_value.setText(db.readHair(friend));

        gender_value = (TextView) findViewById(R.id.gender_value);
        gender_value.setText(db.readGender(friend));

        location_value = (TextView) findViewById(R.id.location_value);
        location_value.setText(db.readLocation(friend));

        inclination_value = (TextView) findViewById(R.id.inclination_value);
        inclination_value.setText(db.readPreferences(friend));

        db.closeDB();


    }
}
