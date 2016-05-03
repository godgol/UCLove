package com.example.christophe.uclove;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Thomas on 03/05/2016.
 */
class DBHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "MyDBName.db";
    private static final String MESSAGES_TABLE_NAME = "Messages";
    public static final String MESSAGES_COLUMN_RECEIVER = "receiver";
    public static final String MESSAGES_COLUMN_SENDER = "sender";
    public static final String MESSAGES_COLUMN_MESSAGE = "msg";
    public static final String MESSAGES_COLUMN_TIME = "time";
//    private HashMap hp;

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table messages " +
                        "(sender text primary key, receiver text,msg text,time text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public boolean adMessage  (String receiver, String sender, String msg)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("receiver", receiver);
        contentValues.put("sender", sender);
        contentValues.put("msg", msg);
        contentValues.put("time", Date(int year,int month,int date,int hrs,int min));
        db.insert("Messages", null, contentValues);
        return true;
    }

    public Cursor getData(String sender, String receiver){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Messages where receiver="+receiver+",sender="+sender+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, MESSAGES_TABLE_NAME);
    }

    public ArrayList<String> getAllMessages(String sender, String receiver)
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from messages where receiver="+receiver+", sender="+sender+"", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(MESSAGES_TABLE_NAME)));
            res.moveToNext();
        }
        return array_list;
    }

}
