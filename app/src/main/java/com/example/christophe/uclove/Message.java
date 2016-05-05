package com.example.christophe.uclove;

import java.lang.String;
import java.util.Date;

/**
 * Created by Guillaume on 01-05-16.
 * Modified by Thomas on 04-05-2016.
 */
public class Message {

    private String time;
    private String message;
    private String sender;
    private String receiver;

    public Message()
    {

    }

    public Message(String time,String message,String receiver, String sender){//constructeur
        this.time=time;
        this.message=message;
        this.sender=sender;
        this.receiver=receiver;

    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
