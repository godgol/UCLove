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
public class NameActivity extends Activity {
    public EditText name;
    public Button nameOk;
    public String login = CurrentUser.current_user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_name);
        name = (EditText) findViewById(R.id.name);
        nameOk = (Button) findViewById(R.id.nameOk);

        //Boutton pour valider le nom de famille
        nameOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                DatabaseHandler2 db = new DatabaseHandler2(NameActivity.this);
                db.updateFamilyName(login, name.getText().toString());
                db.closeDB();
                Intent i = new Intent(NameActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });
    }
}