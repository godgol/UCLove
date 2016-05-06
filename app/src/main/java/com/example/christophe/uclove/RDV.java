package com.example.christophe.uclove;
import java.security.Timestamp;

public class RDV {
    public String date;
    public String sender;
    public String receiver;
    public String etat;

    public RDV(){

    }

    public  RDV (String date, String sender, String receiver, String etat){
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
        this.etat = etat;
    }

    public String getEtat() {
        return etat;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSender() {
        return sender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

}