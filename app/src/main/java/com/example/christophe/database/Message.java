package com.example.christophe.database;

import java.security.Timestamp;

/**
 * Created by Guillaume on 01-05-16.
 */
public class Message {

    public Timestamp time;
    public String message;
    public My_User sender;
    public User_Friend receiver;

    public Message(Timestamp time,String message,User_Friend receiver, My_User sender){//constructeur
        this.time=time;
        this.message=message;
        this.sender=sender;
        this.receiver=receiver;

    }
}
