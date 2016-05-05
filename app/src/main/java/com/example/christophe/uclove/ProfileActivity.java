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


public class ProfileActivity extends AppCompatActivity{
    private RadioGroup groupGender = null;
    private EditText age;
    private RadioGroup groupHairs = null;
    private RadioGroup groupEye = null;
    private EditText location = null;
    private RadioGroup groupInclination = null;
    private Button gallery = null;
    private Button ageOk = null;
    private Button locationOk = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_content);

        location = (EditText)findViewById(R.id.location);
        groupGender = (RadioGroup) findViewById(R.id.groupGender);
        groupHairs = (RadioGroup) findViewById(R.id.groupHairs);
        groupEye = (RadioGroup) findViewById(R.id.groupEye);
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
                    case R.id.brownHair:
                        break;
                    case R.id.blackHair:
                        break;
                    case R.id.blondHair:
                        break;
                    case R.id.redHair:
                        break;
                }
            }
        });
        groupEye.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch(checkedId)
                {
                    case R.id.brownEye:
                        break;
                    case R.id.blueEye:
                        break;
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
                String str = age.getText().toString();
                int userAge = Integer.valueOf(str);
                if(userAge<13){
                    Toast.makeText(ProfileActivity.this,"You're too young for using this application !",Toast.LENGTH_SHORT).show();
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