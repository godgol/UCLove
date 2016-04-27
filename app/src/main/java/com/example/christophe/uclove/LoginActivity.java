package com.example.christophe.uclove;

import android.app.ListActivity;
import java.util.List;
import java.util.Arrays;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.content.Intent;

import com.example.christophe.database.MySQLiteOpenHelper;

/**
 * Created by Christophe on 26.04.2016.
 */
public class LoginActivity extends AppCompatActivity {
    public Button loginButton;
    private TextView login_status;
    public String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);
        MySQLiteOpenHelper db = new MySQLiteOpenHelper(this);

//        if(db.open()){
//            password = db.getPassword("PaulDuChateau");
//            db.close();
//        }
//        else{
//            throw new Error("Impossible to open database");
//        }

        login_status = (TextView) findViewById(R.id.login_status);
        loginButton = (Button) findViewById(R.id.LoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(LoginActivity.this, MyListActivity.class);
                startActivity(i);
//                login_status.setText(password);
            }
        });
    }
}
