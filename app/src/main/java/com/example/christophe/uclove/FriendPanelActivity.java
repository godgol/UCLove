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



    TextView genre_value = null;
    TextView age_value= null;
    TextView hair_value = null;
    TextView eyes_value = null;
    TextView location_value = null;
    TextView inclination_value = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_friendpanel);
        genre_value =  (TextView) findViewById(R.id.gender_value);
        genre_value.setText("Singe"); // Avec la base de donnée on irait dans la array list de user, chercher un friend et faire friend.getGender();

        age_value = (TextView) findViewById(R.id.age_value);
        age_value.setText("23");

        hair_value = (TextView) findViewById(R.id.hair_value);
        hair_value.setText("Noir");

        eyes_value = (TextView) findViewById(R.id.eyes_value);
        eyes_value.setText("Marron");

        location_value = (TextView) findViewById(R.id.location_value);
        location_value.setText("Zimbabwe");

        inclination_value = (TextView) findViewById(R.id.inclination_value);
        inclination_value.setText("Ouvert à toute possibilité");


    }
}
