package com.example.christophe.database;
import java.security.Timestamp;

public class RDV {
    public Timestamp date;
    public String sender;
    public String receiver;
    public String etat;
    public  RDV (Timestamp date, String sender, String receiver, String etat){
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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