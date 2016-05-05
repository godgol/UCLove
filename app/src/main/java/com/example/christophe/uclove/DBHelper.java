package com.example.christophe.uclove;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Thomas on 05/05/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String MESSAGES_TABLE_NAME = "messages";
    public static final String SENDER = "sender";
    public static final String RECEIVER = "receiver";
    public static final String MSG = "msg";
    public static final String DATE= "date";

    public static final String MESSAGES_TABLE_CREATE = "CREATE TABLE" + MESSAGES_TABLE_NAME + "(" +
            SENDER + " TEXT, " + RECEIVER + " TEXT, " + MSG + " TEXT, " + DATE + "TEXT," +");";

    public static final String MESSAGES_TABLE_DROP = "DROP TABLE IF EXISTS" + MESSAGES_TABLE_NAME + ";";

    public DBHelper (Context context, String name, SQLiteDatabase.CursorFactory cursorFactory, int version){

        super(context, name, cursorFactory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(MESSAGES_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL(MESSAGES_TABLE_DROP);
        onCreate(db);
    }
}
