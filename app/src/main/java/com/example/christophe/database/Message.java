package com.example.christophe.database;

import java.security.Timestamp;

/**
 * Created by Guillaume on 01-05-16.
 */
public class Message {

    public Timestamp time;
    public String message;
    public Profile sender;
    public Profile receiver;

    public message(Timestamp time,String message,Profile receiver){//constructeur
        this.time=time;
        this.message=message;
       // this.sender=sender;
        this.receiver=receiver;

    }
}
