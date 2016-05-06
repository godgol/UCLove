package com.example.christophe.uclove;

import android.support.v7.app.AppCompatActivity;
import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.content.Intent;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity{
    public RadioGroup groupGender;
    public RadioGroup groupHairs;
    public RadioGroup groupEyes;
    public RadioGroup groupInclination;
    public RadioGroup groupLanguage;
    public Button gallery;
    public Button ageChange;
    public Button locationChange;
    public Button firstNameChange;
    public Button nameChange;
    public String login = CurrentUser.current_user;
    public TextView age;
    public TextView location;
    public TextView firstName;
    public TextView name;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_content);

        location = (TextView)findViewById(R.id.location);
        groupGender = (RadioGroup) findViewById(R.id.groupGender);
        groupHairs = (RadioGroup) findViewById(R.id.groupHairs);
        groupEyes = (RadioGroup) findViewById(R.id.groupEyes);
        groupInclination = (RadioGroup) findViewById(R.id.groupInclination);
        groupLanguage=(RadioGroup)findViewById(R.id.groupLanguage);
        age = (TextView) findViewById(R.id.age);
        gallery = (Button)findViewById(R.id.gallery);
        ageChange = (Button)findViewById(R.id.ageChange);
        locationChange = (Button)findViewById(R.id.locationChange);
        firstNameChange = (Button)findViewById(R.id.firstNameChange);
        nameChange = (Button)findViewById(R.id.nameChange);
        firstName = (TextView) findViewById(R.id.firstName);
        name = (TextView) findViewById(R.id.name);

        DatabaseHandler2 db = new DatabaseHandler2(ProfileActivity.this);

        String gen = db.readGender(login);
        if(gen.compareTo("male")==0)
            groupGender.check(R.id.male);
        else if (gen.compareTo("female")==0)
            groupGender.check(R.id.female);

        String hair = db.readHair(login);
        if(hair.compareTo("brown")==0)
            groupHairs.check(R.id.brownHairs);
        else if(hair.compareTo("blond")==0)
            groupHairs.check(R.id.blondHairs);
        else if(hair.compareTo("black")==0)
            groupHairs.check(R.id.blackHairs);
        else if(hair.compareTo("red")==0)
            groupHairs.check(R.id.redHairs);

        String eyes=db.readEyes(login);
        if(eyes.compareTo("brown")==0)
            groupEyes.check(R.id.brownEyes);
        else if(eyes.compareTo("blue")==0)
            groupEyes.check(R.id.blueEyes);
        else if(eyes.compareTo("green")==0)
            groupEyes.check(R.id.greenEyes);

        String pref=db.readPreferences(login);
        if(pref.compareTo("hetero")==0)
            groupInclination.check(R.id.hetero);
        else if(pref.compareTo("homo")==0)
            groupInclination.check(R.id.homo);
        else if(pref.compareTo("bi")==0)
            groupInclination.check(R.id.bi);

        String lan=db.readLanguage(login);
        if(lan.compareTo("english")==0)
            groupLanguage.check(R.id.english);
        else if(lan.compareTo("french")==0)
            groupLanguage.check(R.id.french);

        age.setText(String.valueOf(db.readAge(login)));

        location.setText(db.readLocation(login));

        firstName.setText(db.readName(login));

        name.setText(db.readFamilyName(login));

        db.closeDB();
        groupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                DatabaseHandler2 db1 = new DatabaseHandler2(ProfileActivity.this);
                switch(checkedId)
                {
                    case R.id.male:
                        db1.updateGender(login,"'male'");
                        break;
                    case R.id.female:
                        db1.updateGender(login,"'female'");
                        break;
                }
                db1.closeDB();
            }
        });

        groupHairs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                DatabaseHandler2 db = new DatabaseHandler2(ProfileActivity.this);
                switch (checkedId) {
                    case R.id.brownHairs:
                        db.updateHair(login,"brown");
                        break;
                    case R.id.blackHairs:
                        db.updateHair(login,"black");
                        break;
                    case R.id.blondHairs:
                        db.updateHair(login,"blond");
                        break;
                    case R.id.redHairs:
                        db.updateHair(login,"red");
                        break;
                }
                db.closeDB();
            }
        });

        groupEyes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                DatabaseHandler2 db = new DatabaseHandler2(ProfileActivity.this);
                switch(checkedId)
                {
                    case R.id.brownEyes:
                        db.updateEyes(login,"brown");
                        break;
                    case R.id.blueEyes:
                        db.updateEyes(login,"blue");
                        break;
                    case R.id.greenEyes:
                        db.updateEyes(login,"green");
                        break;
                }
                db.closeDB();
            }
        });

        groupInclination.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                DatabaseHandler2 db = new DatabaseHandler2(ProfileActivity.this);
                switch(checkedId)
                {
                    case R.id.hetero:
                        db.updatePreferences(login,"hetero");
                        break;
                    case R.id.homo:
                        db.updatePreferences(login,"homo");
                        break;
                    case R.id.bi:
                        db.updatePreferences(login,"bi");
                        break;
                }
                db.closeDB();
            }
        });
        System.out.println("yo");

        groupLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                DatabaseHandler2 db = new DatabaseHandler2(ProfileActivity.this);
                switch (checkedId) {
                    case R.id.french:
                        db.updateLanguage(login,"french");
                        break;
                    case R.id.english:
                        db.updateLanguage(login,"english");
                        break;
                }
                db.closeDB();
            }
        });
        System.out.println("yo");

        locationChange.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Intent i = new Intent(ProfileActivity.this, LocationActivity.class);
                    startActivity(i);
                    return true;
                } else {
                }
                return false;
            }
        });
        System.out.println("yo");
        ageChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(ProfileActivity.this, AgeActivity.class);
                startActivity(i);
            }
        });

        firstNameChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(ProfileActivity.this, FirstNameActivity.class);
                startActivity(i);
            }
        });

        nameChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(ProfileActivity.this, NameActivity.class);
                startActivity(i);
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(ProfileActivity.this, GalleryActivity.class);
                startActivity(i);
            }
        });
    }
}
