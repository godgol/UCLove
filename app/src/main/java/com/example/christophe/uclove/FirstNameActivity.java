package com.example.christophe.uclove;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
public class FirstNameActivity extends Activity {
    public EditText firstName;
    public Button firstNameOk;
    public String login = CurrentUser.current_user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_firstname);
        firstName = (EditText) findViewById(R.id.firstName);
        firstNameOk = (Button) findViewById(R.id.firstNameOk);

        firstNameOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                DatabaseHandler2 db = new DatabaseHandler2(FirstNameActivity.this);
                db.updateName(login, firstName.getText().toString());
                db.closeDB();
                Intent i = new Intent(FirstNameActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });
    }
}