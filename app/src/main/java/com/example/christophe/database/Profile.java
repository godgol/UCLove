package com.example.christophe.database;

/**
 * Created by Christophe on 27.04.2016.
 */
public class Profile {

    //private variables
    String Login;
    String FamilyName;
    String Name;
    int Age;
    String Gender;
    String Hair;
    String Eyes;
    String Location;
    String Preferences;
    String Password;
    String Languages;

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
