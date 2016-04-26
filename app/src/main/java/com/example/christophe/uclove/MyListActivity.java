package com.example.christophe.uclove;

import android.app.ListActivity;
import java.util.List;
import java.util.Arrays;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.content.Intent;

public class MyListActivity extends AppCompatActivity {
    public TextView profile;

//    @Override
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.content_menu);
//
//        profile = (TextView)findViewById(R.id.T1);
//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                profile.setBackgroundColor(getResources().getColor(R.color.grey));
//                Intent intent = new Intent(MyListActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_menu);

        profile = (TextView) findViewById(R.id.T1);
        profile.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Intent intent = new Intent(MyListActivity.this, LoginActivity.class);
                    startActivity(intent);
                    return true;
                } else {
                    profile.setBackgroundColor(getResources().getColor(R.color.lightred));
                }
                return false;
            }
        });
    }
}

