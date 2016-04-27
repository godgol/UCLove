package com.example.christophe.uclove;

import android.app.ListActivity;
import java.util.List;
import java.util.Arrays;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.content.Intent;
import com.example.christophe.database.DatabaseHandler;
import com.example.christophe.database.Profile;

/**
 * Created by Christophe on 26.04.2016.
 */
public class LoginActivity extends AppCompatActivity {
    public Button loginButton;
    private TextView login_status;
    public String login;
    public String password = "None";
    public EditText login_edit;
    public EditText pw_edit;
    public Profile useracc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);

        login_status = (TextView) findViewById(R.id.login_status);
        login_edit = (EditText) findViewById(R.id.LogInput);
        pw_edit = (EditText) findViewById(R.id.PwInput);
        loginButton = (Button) findViewById(R.id.LoginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                login = login_edit.getText().toString();
                password = pw_edit.getText().toString();
                DatabaseHandler db = new DatabaseHandler(LoginActivity.this);

                useracc = db.getProfile(login);

                if(useracc.getPassword()==password){
                    Intent i = new Intent(LoginActivity.this, MyListActivity.class);
                    startActivity(i);
                }
                else{
                    login_status.setText("Wrong Password");
                }

//                db.createProfile(new Profile(login, password));
//                login_status.setText(password);

//                else {
//                    Intent i = new Intent(LoginActivity.this, MyListActivity.class);
//                    startActivity(i);
//                }
            }
        });
    }
}

