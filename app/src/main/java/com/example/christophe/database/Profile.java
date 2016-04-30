package com.example.christophe.database;

import android.graphics.Picture;

import java.security.PrivateKey;
import java.util.jar.Attributes;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
 * Created by Christophe on 27.04.2016.
 */
public class Profile {

    //protected variables
    protected String Login;
    protected String FamilyName;
    protected String Name;
    protected int Age;
    protected String Gender;
    protected String Hair;
    protected String Eyes;
    protected String Location;
    protected String Preferences;
    protected String Password;
    protected String Languages;
    protected ArrayList AlPictures;

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
        this.AlPictures = new ArrayList();
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

    // getting Name
    public String getName() { return this.Name; }

    // setting Name
    public void setName(String name) { this.Name = name; }

    // getting Hair
    public String getHair() { return this.Hair; }

    //setting Hair
    public void setHair(String hair) { this.Hair = hair; }

    //getting Eyes
    public String getEyes() { return this.Eyes; }

    //setting Eyes
    public void setEyes(String eyes) { this.Eyes = eyes; }

    //getting Age
    public int getAge() { return this.Age; }

    //setting Age
    public void setAge(int age) { this.Age = age; }

    //getting Gender
    public String getGender() { return this.Gender; }

    //setting Gender
    public void setGender(String gender) { this.Gender = gender; }

    //getting Languages
    public String getLanguages() { return this.Languages; }

    //setting Languages
    public void setLanguages(String languages) { this.Languages = languages; }

    //getting Preferences
    public String getPreferences() { return this.Preferences; }

    //setting Preferences
    public void setPreferences(String preferences) { this.Preferences = preferences; }

    //getting Location
    public String getLocation() { return this.Location; }

    //setting Location
    public void setLocation(String location) { this.Location = location; }

    //Add picture to ArrayList
   // public void addPic(Picture pic, int i) {this.AlPictures.add(i, pic);} TODO Décommenter quand la classe Picture existera

    //Remove picture i from ArrayList
    public void remPic(int i) {this.AlPictures.remove(i);}

    //Get picture i from ArrayList
   // public Picture getPic(int i) {this.AlPictures.get(i);} TODO Décommenter quand la classe existera

}



