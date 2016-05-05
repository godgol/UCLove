package com.example.christophe.uclove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Christophe on 05.05.2016.
 */
public class PeopleActivity extends AppCompatActivity {

    public String login = "'Jojelavida'";
    /*public String gender;
    public String hair;
    public String location;
    public String age;
    public int age;
    public String eyes;
    public String preferences;*/
    public TextView log;
    public TextView gen;
    public TextView h;
    public TextView loc;
    public TextView ag;
    public TextView ey;
    public TextView pre;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_content);

        gen = (TextView) findViewById(R.id.gender);
        DatabaseHandler2 db = new DatabaseHandler2(PeopleActivity.this);

        //TODO Get Picture
        //log.setText(login);
        gen.setText(db.readGender(login));
        //h.setText(db.readHair(login));
        //loc.setText(db.readLocation(login));
        //ag.setText(db.readAge(login));
        //ey.setText(db.readEyes(login));
        //pre.setText(db.readPreferences(login));

        db.closeDB();

    }
}
