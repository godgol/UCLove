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

        import com.example.christophe.uclove.Profile;

        /**
 * Created by Guillaume on 29-04-16.
 */
public class User_Lambda extends Profile{

public boolean Denied;

 public User_Lambda (String log, String FN, String name, int age, String gender, String hair,
                     String eyes, String location, String preferences, String pw, String languages)
 {
        super(log,FN,name,age,gender,hair,eyes,location,preferences,pw,languages);
        this.Denied = false;
 }
 public void Deny(){this.Denied = true;}
 }