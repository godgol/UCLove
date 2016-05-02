package com.example.christophe.uclove;

import java.security.Timestamp;

//package java.sql;

public class Date_Dispo {
    public Timestamp date;
    public String user;
    public Date_Dispo(Timestamp date, String user){
        this.date = date;
        this.user = user;
    }

    public Timestamp getDate(){
        return this.date;
    }
    public String getUser(){
        return this.user;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setUser(String user) {
        this.user = user;
    }
}