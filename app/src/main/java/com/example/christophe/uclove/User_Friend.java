package com.example.christophe.uclove;

import java.util.ArrayList;


import com.example.christophe.uclove.Profile;

/**
 * Created by Guillaume on 29-04-16.
 */
public class User_Friend extends Profile {



    ArrayList messagerie = new ArrayList(); //liste des messages
    public User_Friend(User_Lambda lambda)//constructeur qui prend en argument un user_lambda
    {
    super(lambda.getLogin(), lambda.getFamilyName(), lambda.getName(), lambda.getAge(), lambda.getGender(),
            lambda.getHair(), lambda.getEyes(), lambda.getLocation(), lambda.getPreferences(),
            lambda.getPassword(), lambda.getLanguages());
    }

    public User_Friend(Profile profile){

        super(profile.getLogin(), profile.getFamilyName(), profile.getName(), profile.getAge(),
                profile.getGender(),profile.getHair(), profile.getEyes(), profile.getLocation(),
                profile.getPreferences(),profile.getPassword(), profile.getLanguages());
    }

    public void Show_Date_dispo(){//je vois pas trop comment faire ça

    }



}
