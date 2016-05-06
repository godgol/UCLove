package com.example.christophe.uclove;

import android.support.v7.app.AppCompatActivity;
import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import android.widget.EditText;
public class AgeActivity extends Activity{
    public EditText age;
    public Button ageOk;
    public String login = CurrentUser.current_user;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_age);
        age = (EditText) findViewById(R.id.age);
        ageOk = (Button) findViewById(R.id.ageOk);

        ageOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String str = age.getText().toString();
                int ageUser = Integer.valueOf(str);
                if (ageUser < 13)
                    Toast.makeText(AgeActivity.this, "You're too young for using this application", Toast.LENGTH_SHORT).show();
                else {
                    //DatabaseHandler2 db = new DatabaseHandler2(AgeActivity.this);
                    //db.updateAge(login, ageUser);
                    //db.closeDB();
                    Intent i = new Intent(AgeActivity.this, ProfileActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}