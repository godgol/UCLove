package com.example.christophe.database;

import java.security.PrivateKey;

/**
 * Created by Christophe on 27.04.2016.
 */
public class Profile {

    //private variables
    Private String Login;
    Private String FamilyName;
    Private String Name;
    Private int Age;
    Private String Gender;
    Private String Hair;
    Private String Eyes;
    Private String Location;
    Private String Preferences;
    Private String Password;
    Private String Languages;

    // Empty constructor
    public Profile() {

    }

    // constructor with Login and Password
    public Profile(String log, String pw) {
        this.Login = log;
        this.Password = pw;
    }

    // constructor with all variables
    public Profile(String log, String FN, String name, int age, String gender, String hair,
                   String eyes, String location, String preferences, String pw, String languages) {
        this.Login = log;
        this.FamilyName = FN;
        this.Name = name;
        this.Age = age;
        this.Gender = gender;
        this.Hair = hair;
        this.Eyes = eyes;
        this.Location = location;
        this.Preferences = preferences;
        this.Password = pw;
        this.Languages = languages;
    }

    // getting Login
    public String getLogin() {
        return this.Login;
    }

    // setting Login
    public void setLogin(String log) {
        this.Login = log;
    }

    // getting FamilyName
    public String getFamilyName() {
        return this.FamilyName;
    }

    // setting FamiylName
    public void setFamilyName(String FN) {
        this.FamilyName = FN;
    }

    // getting Password
    public String getPassword() {
        return this.Password;
    }

    // setting Password
    public void setPassword(String pw) {
        this.Password = pw;
    }
}
