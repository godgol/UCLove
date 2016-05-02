package com.example.christophe.uclove;

import java.lang.reflect.Array;
import java.util.ArrayList;
import android.graphics.Picture;

import java.security.PrivateKey;
import java.util.jar.Attributes;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
 * Created by antoine on 30/04/16.
 */
public class My_User extends Profile{

    //Private Variable
    private ArrayList AlUser_Lambda;
    private ArrayList AlUser_Friend;
    private ArrayList AlFriend_Request;
    private ArrayList AlRDV;
    private ArrayList AlDate_Dispo;

    //TODO Ajouter un attribut Int index à tous les objets se trouvant dans une ArrayList pour les manipuler plus facielement
    //Constructeur
    public My_User(String log, String FN, String name, int age, String gender, String hair,
                   String eyes, String location, String preferences, String pw, String languages)
    {
        super( log, FN, name, age, gender, hair,
             eyes, location, preferences, pw, languages); // Fait appel au constructeur de la classe mère
        this.AlDate_Dispo=new ArrayList();
        this.AlFriend_Request=new ArrayList();
        this.AlRDV=new ArrayList();
        this.AlUser_Friend=new ArrayList();
        this.AlUser_Lambda=new ArrayList();
    }

    //Fonction de manipulation des ArrayList

    //Add Date_Dispo to ArrayList
     public void addDate_Dispo(Date_Dispo date, int i) {this.AlDate_Dispo.add(i, date);}

    //Remove Date_Dispo i from ArrayList
    public void remDate_Dispo(int i) {this.AlDate_Dispo.remove(i);}

    //Get Date_Dispo i from ArrayList
    public Date_Dispo getPic(int i) {return (Date_Dispo)this.AlDate_Dispo.get(i);}

    //Add Friend_Request to ArrayList
    public void addFriend_Request(Friend_Request requ, int i){this.AlFriend_Request.add(i, requ);}

    //Remove Friend_Request i from ArrayList
    public void remFriend_Request(int i) {this.AlFriend_Request.remove(i);}

    //Get Friend_Request i from ArrayList
    public Friend_Request getFriend_Request(int i) {return (Friend_Request)this.AlFriend_Request.get(i);}

    //Add RDV to ArrayList
    public void addRDV(RDV rdv ,int i){this.AlRDV.add(i, rdv);}

    //Remove RDV from ArrayList
    public void remRDV (int i) {this.AlRDV.remove(i);}

    //Get TDV from ArrayList
    public RDV getRDV (int i) {return (RDV) this.AlRDV.get(i);}

    //Add User_Friend to ArrayList
    public void addUser_Friend(User_Friend friend, int i) {this.AlUser_Friend.add(i, friend);}

    //Remove User_Friend from ArrayList
    public void remUser_Friend(int i) {this.AlUser_Friend.remove(i);}

    //Get User_Friend from ArrayList
    public User_Friend getUser_Friend(int i) {return (User_Friend) this.AlUser_Friend.get(i);}

    //Add com.example.christophe.uclove.User_Lambda to ArrayList
     public void addUser_Lambda(User_Lambda lambda, int i) {this.AlUser_Lambda.add(i, lambda);}

    //Remove com.example.christophe.uclove.User_Lambda from ArrayList
    public void remUser_Lambda(int i) {this.AlUser_Lambda.remove(i);}

    //Get com.example.christophe.uclove.User_Lambda from ArrayList
    public User_Lambda getUser_Lambda (int i) {return (User_Lambda)this.AlUser_Lambda.get(i);}


}
