package com.example.christophe.uclove;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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
public class FriendPanelActivity extends AppCompatActivity{

    //@Override
    TextView genre_value = null;

    public void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_friendpanel);

        genre_value =  (TextView) findViewById(R.id.gender_value);
        genre_value.setText("Singe"); // Avec la base de donnée on irait dans la array list de user, chercher un friend et faire friend.getGender();





    }



}
