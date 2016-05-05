package com.example.christophe.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Thomas on 05/05/2016.
 */
public class DBChat extends DBHandler {

    public DBChat(Context context) {

        super(context);
    }

    public void add(Message msg) {

        ContentValues val = new ContentValues();
        val.put(DBHelper.SENDER, msg.getSender());
        val.put(DBHelper.RECEIVER, msg.getReceiver());
        val.put(DBHelper.MSG, msg.getMessage());
        val.put(DBHelper.DATE, msg.getTime());
        mDB.insert(DBHelper.MESSAGES_TABLE_NAME, null, val);
    }

    public ArrayList<Message> Conversation(String sender, String receiver) {

        String bubble = "select sender, receiver, msg, date from " + DBHelper.MESSAGES_TABLE_NAME
                + " where ( sender = \"" + sender + "\" or sender = \"" + receiver + "\")" +
                " and ( receiver = \"" + sender + "\" or receiver = \"" + receiver + "\");";

        Cursor cursor = mDB.rawQuery(bubble, new String[]{});

        ArrayList<Message> list = new ArrayList<Message>();

        while (cursor.moveToNext()) {

            Message message = new Message();

            message.setSender(cursor.getString(0));
            message.setReceiver(cursor.getString(1));
            message.setMessage(cursor.getString(2));
            message.setTime(cursor.getString(3));
            list.add(message);
        }
        cursor.close();
        return list;

    }
}
