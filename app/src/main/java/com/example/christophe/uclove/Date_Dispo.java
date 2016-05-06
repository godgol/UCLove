package com.example.christophe.uclove;

import java.security.Timestamp;

//package java.sql;

public class Date_Dispo {
    public String date;
    public String user;

    public Date_Dispo(){

    }

    public Date_Dispo(String date, String user){
        this.date = date;
        this.user = user;
    }

    public String getDate(){
        return this.date;
    }
    public String getUser(){
        return this.user;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public void setUser(String user) {
        this.user = user;
    }
}