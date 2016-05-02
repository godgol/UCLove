package com.example.christophe.database;

import android.app.ListActivity;

import java.util.ArrayList;
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
import java.util.Date;
import java.lang.Object;


import com.example.christophe.database.My_User;
import com.example.christophe.database.Profile;

/**
 * Created by Guillaume on 29-04-16.
 */
public class User_Friend extends Profile {


    ArrayList messagerie = new ArrayList(); //liste des messages
    public User_Friend(User_Lambda lambda)//constructeur qui prends en argument un userlambda
    {
    super(lambda.getLogin(), lambda.getFamilyName(), lambda.getName(), lambda.getAge(), lambda.getGender(), lambda.getHair(),
            lambda.getEyes(), lambda.getLocation(), lambda.getPreferences(), lambda.getPassword(), lambda.getLanguages())
    }

    public void Show_Date_dispo(){//je vois pas trop comment faire ça

    }

    public void Add_Message(String message, My_User myuser) {
        messagerie.add(new Message(ZoneDateTime.now(),message,this, myuser) )
    }

}
