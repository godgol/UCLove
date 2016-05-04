package com.example.christophe.uclove;

public class Friend_Request {
    public String sender;
    public String receiver;
    public String etat;

    public Friend_Request(String sender, String receiver, String etat){
        this.sender = sender;
        this.receiver = receiver;
        this.etat = etat;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setEtat(String etat) {
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

    public String toString(){
    return (this.getSender()+"invited"+this.getReceiver()+"and is"+this.getEtat());
    }
}
