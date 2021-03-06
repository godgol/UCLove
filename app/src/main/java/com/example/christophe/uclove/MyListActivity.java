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

import org.w3c.dom.Text;

/*
MENU DE L'APPLICATION
 */


public class MyListActivity  extends AppCompatActivity {
    public TextView profile;
    Profile update = new Profile();
    public TextView request;
    String login ;
    public TextView friends;
    public TextView meet;
    public TextView people;
    public TextView messages;


//    @Override
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.content_menu);
//
//        profile = (TextView)findViewById(R.id.T1);
//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                profile.setBackgroundColor(getResources().getColor(R.color.lightred));
//                Intent intent = new Intent(MyListActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_menu);

        //Lier les bouttons à leur layout
        System.out.println("TestList1");
        profile = (TextView) findViewById(R.id.T1);
        request = (TextView) findViewById(R.id.T7);
        people = (TextView) findViewById(R.id.T3);
        friends = (TextView) findViewById(R.id.T4);
        meet = (TextView) findViewById(R.id.T5);
        messages = (TextView) findViewById(R.id.T6);


        //Boutton Profile
        profile.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    profile.setBackgroundColor(getResources().getColor(R.color.white));
                    System.out.println("TestList2");
                    Intent intent = new Intent(MyListActivity.this, ProfileActivity.class);
                    startActivity(intent);
                    System.out.println("TestList3");
                    return true;
                } else {
                    profile.setBackgroundColor(getResources().getColor(R.color.lightred));
                    System.out.println("TestList4");
                }
                return false;
            }
        });

        //Boutton messages
        messages.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    messages.setBackgroundColor(getResources().getColor(R.color.white));
                    System.out.println("TestList2");
                    Intent intent = new Intent(MyListActivity.this, MsgChooseFriend.class);
                    startActivity(intent);
                    System.out.println("TestList3");
                    return true;
                } else {
                    messages.setBackgroundColor(getResources().getColor(R.color.lightred));
                    System.out.println("TestList4");
                }
                return false;
            }
        });

        //Boutton people
        people.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent  event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    people.setBackgroundColor(getResources().getColor(R.color.white));
                    people.setBackgroundColor(getResources().getColor(R.color.lightred));
                    Intent i = new Intent(MyListActivity.this, PeopleActivity.class);
                    startActivity(i);
                    return true;
                }
                else{
                    people.setBackgroundColor(getResources().getColor(R.color.lightred));
                }
                return false;
            }
        });

        //Bouton friends
        friends.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent  event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    friends.setBackgroundColor(getResources().getColor(R.color.white));
                    Intent i = new Intent(MyListActivity.this, FriendsActivity.class);
                    startActivity(i);
                    return true;
                }
                else{
                    friends.setBackgroundColor(getResources().getColor(R.color.lightred));
                }
                return false;
            }
        });

        //Boutton Meet
        meet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent  event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    meet.setBackgroundColor(getResources().getColor(R.color.white));
                    Intent i = new Intent(MyListActivity.this, Calendar_activity.class);
                    startActivity(i);
                    return true;
                }
                else{
                    meet.setBackgroundColor(getResources().getColor(R.color.lightred));
                }
                return false;
            }
        });

        //Boutton Request
        request.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                DatabaseHandler2 db2 = new DatabaseHandler2(MyListActivity.this);
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    request.setBackgroundColor(getResources().getColor(R.color.white));
                    Intent intent2 = new Intent(MyListActivity.this, RequestActivity.class);
                    startActivity(intent2);
                    return true;
                } else{
                    request.setBackgroundColor(getResources().getColor(R.color.lightred));
                }
                return false;
            }
        });

    }
}

