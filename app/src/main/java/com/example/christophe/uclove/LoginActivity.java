package com.example.christophe.uclove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

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
                System.out.println("I'm here before");


                DatabaseHandler2 db = new DatabaseHandler2(LoginActivity.this);

                System.out.println("I'm here after");

                useracc = db.getProfile(login);
                db.closeDB();
                System.out.println("I'm here");
                if(useracc.getPassword().equals(password)){
                    System.out.println("I'm here 2");
                    CurrentUser.current_user = login;
                    Intent i = new Intent(LoginActivity.this, MyListActivity.class);
                    startActivity(i);
                    System.out.println("I'm here 3");
                }
                else{
                    login_status.setText("Wrong Password");
                    System.out.println("I'm here 4");
                }

//                db.createProfile(new Profile(login, password));
//                login_status.setText(password);

            }
        });
    }
}

