package com.example.christophe.uclove;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Thomas on 05/05/2016.
 */
public abstract class DBHandler {

    protected final static int VERSION = 1;

    protected final static String Nom = "database.sqlite";

    protected SQLiteDatabase mDB = null;
    protected DBHelper helper = null;

    public DBHandler (Context context){

        this.helper = new DBHelper(context, Nom, null, VERSION);
    }

    public SQLiteDatabase open(){

        mDB = helper.getWritableDatabase();
        return mDB;
    }

    public void close(){

        mDB.close();
    }

    public SQLiteDatabase getmDB(){

        return mDB;
    }
}
