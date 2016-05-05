package com.example.christophe.uclove;

import android.support.v7.app.AppCompatActivity;
import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.content.Intent;
import android.widget.Toast;


/*public class ProfileActivity extends AppCompatActivity{
    private RadioGroup groupGender = null;
    private EditText age;
    private RadioGroup groupHairs = null;
    private RadioGroup groupEyes = null;
    private EditText location = null;
    private RadioGroup groupInclination = null;
    private Button gallery = null;
    private Button ageOk = null;
    private Button locationOk = null;
    private String login = CurrentUser.current_user;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_content);

        location = (EditText)findViewById(R.id.location);
        groupGender = (RadioGroup) findViewById(R.id.groupGender);
        groupHairs = (RadioGroup) findViewById(R.id.groupHairs);
        groupEyes = (RadioGroup) findViewById(R.id.groupEyes);
        groupInclination = (RadioGroup) findViewById(R.id.groupInclination);
        age = (EditText)findViewById(R.id.age);
        gallery = (Button)findViewById(R.id.gallery);
        ageOk = (Button)findViewById(R.id.ageOk);
        locationOk = (Button)findViewById(R.id.locationOk);

        groupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                DatabaseHandler2 db = new DatabaseHandler2(ProfileActivity.this);
                switch(checkedId)
                {
                    case R.id.male:
                        db.updateGender(login,"male");
                        break;
                    case R.id.female:
                        db.updateGender(login,"female");
                        break;
                }
                db.closeDB();
            }
        });
        groupHairs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                DatabaseHandler2 db = new DatabaseHandler2(ProfileActivity.this);
                switch(checkedId)
                {
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
        locationOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String loc = location.getText().toString();
                if(loc==""){
                    Toast.makeText(ProfileActivity.this,"Please, enter your location.",Toast.LENGTH_SHORT).show();
                }
                else{
                    DatabaseHandler2 db = new DatabaseHandler2(ProfileActivity.this);
                    db.updateLocation(login,loc);
                    db.closeDB();
                }
            }
        });
        ageOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String str = age.getText().toString();
                if(str==""){
                    Toast.makeText(ProfileActivity.this,"Please, enter your age.",Toast.LENGTH_SHORT).show();
                }
                else {
                    int userAge = Integer.valueOf(str);
                    if(userAge<13){
                        Toast.makeText(ProfileActivity.this,"You're too young for using this application !",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        DatabaseHandler2 db = new DatabaseHandler2(ProfileActivity.this);
                        db.updateAge(login,ageUser);
                        db.closeDB();
                    }
                }
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
}*/