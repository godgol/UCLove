package com.example.christophe.uclove;

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
import android.widget.Toast


public class ProfileActivity extends Activity {
    public RadioGroup groupGender;
    public EditText age;
    public RadioGroup groupHairs;
    public RadioGroup groupEyes;
    public EditText location;
    public RadioGroup groupInclination;
    public Button gallery;
    public Button ageOk;
    public Button locationOk;
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
                switch(checkedId)
                {
                    case R.id.male:
                        break;
                    case R.id.female:
                        break;
                }
            }
        });
        groupHairs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch(checkedId)
                {
                    case R.id.brownHairs:
                        break;
                    case R.id.blackHairs:
                        break;
                    case R.id.blondHairs:
                        break;
                    case R.id.redHairs:
                        break;
                    case R.id.bald:
                        break;
                }
            }
        });
        groupEyes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch(checkedId)
                {
                    case R.id.brownEyes:
                        break;
                    case R.id.blueEyes:
                        break;
                    case R.id.greenEyes:
                }
            }
        });
        groupInclination.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch(checkedId)
                {
                    case R.id.hetero:
                        break;
                    case R.id.homo:
                        break;
                    case R.id.bi:
                        break;
                }
            }
        });
        locationOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String loc = location.getText().toString();
            }
        });
        ageOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String str = location.getText().toString();
                try{
                    int userAge = Integer.parseInt(str);
                    if(userAge<13) {
                        Toast.makeText(getBaseContext(), "You're too young for using this application !", Toast.LENGTH_SHORT).show();
                    }
                }
                catch(NumberFormatException e){
                    Toast.makeText(getBaseContext(),"Please enter a number !",Toast.LENGTH_SHORT).show();
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
}