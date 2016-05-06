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
public class LocationActivity extends Activity {
    public EditText location;
    public Button locationOk;
    public String login = CurrentUser.current_user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_location);
        location = (EditText) findViewById(R.id.location);
        locationOk = (Button) findViewById(R.id.LocationOk);

        locationOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                DatabaseHandler2 db = new DatabaseHandler2(LocationActivity.this);
                db.updateLocation(login, location.getText().toString());
                db.closeDB();
                Intent i = new Intent(LocationActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });
    }
}