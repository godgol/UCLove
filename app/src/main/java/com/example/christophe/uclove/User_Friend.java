package com.example.christophe.uclove;

import java.util.ArrayList;


import com.example.christophe.uclove.Profile;

/**
 * Created by Guillaume on 29-04-16.
 */
public class User_Friend extends Profile {


    ArrayList messagerie = new ArrayList(); //liste des messages
    public User_Friend(User_Lambda lambda)//constructeur qui prends en argument un userlambda
    {
    super(lambda.getLogin(), lambda.getFamilyName(), lambda.getName(), lambda.getAge(), lambda.getGender(), lambda.getHair(),
            lambda.getEyes(), lambda.getLocation(), lambda.getPreferences(), lambda.getPassword(), lambda.getLanguages());
    }

    public void Show_Date_dispo(){//je vois pas trop comment faire ça

    }

    public void Add_Message(String message, My_User myuser) {
       // messagerie.add(new Message(ZoneDateTime.now(),message,this, myuser) );TODO Gerer l'erreur
    }

}
