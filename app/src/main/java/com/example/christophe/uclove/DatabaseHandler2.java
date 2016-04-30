package com.example.christophe.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Christophe on 27.04.2016.
 */

public class DatabaseHandler2 extends SQLiteOpenHelper{
    // Logcat tag
    private static final String LOG = "DatabaseHandler";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "database.sqlite";

    // Table Names
    private static final String TABLE_PROFILE= "Profile";
    private static final String TABLE_REQUESTLIST = "RequestList";
    private static final String TABLE_FRIENDLIST= "FriendList";
    private static final String TABLE_GALLERY= "Gallery";
    private static final String TABLE_CHAT= "Chat";
    private static final String TABLE_CALENDAR= "Calendar";
    private static final String TABLE_RENDEZVOUS= "Rendezvous";

    // COMMON column names
    private static final String KEY_LOGIN= "Login";

    // PROFILE Table - column names
    private static final String KEY_FAMILYNAME = "FamilyName";
    private static final String KEY_NAME = "Name";
    private static final String KEY_AGE = "Age";
    private static final String KEY_GENDER= "Gender";
    private static final String KEY_HAIR = "Hair";
    private static final String KEY_EYES = "Eyes";
    private static final String KEY_LOCATION = "Location";
    private static final String KEY_PREFERENCES = "Preferences";
    private static final String KEY_PASSWORD = "Password";
    private static final String KEY_LANGUAGE = "Language";

    // REQUEST_LIST Table - column names
    private static final String KEY_REQUESTLOGIN = "RequestLogin";
    private static final String KEY_ANSWER = "Answer";

    // FRIEND_LIST Table - column names
    private static final String KEY_FRIENDLOGIN = "FriendLogin"; //Also used for CHAT Table

    // GALLERY Table - column names
    private static final String KEY_PICTUREID = "PictureID";
    private static final String KEY_PROFILEBINARY = "ProfileBinary";

    // CHAT Table - column names
    private static final String KEY_MESSAGE = "Message";
    private static final String KEY_DATE = "Date";

    //CALENDAR Table - column names
    //Uses Login and Date

    // RENDEZVOUS Table - column names
    // Uses Login, FriendLogin, Date, Location, Answer

    //////////////////////////////
    // Table Create Statements  //
    //////////////////////////////

    // PROFILE Table create statement
    private static final String CREATE_TABLE_PROFILE = "CREATE TABLE "
            + TABLE_PROFILE + "(" + KEY_LOGIN + " TEXT PRIMARY KEY," + KEY_FAMILYNAME
            + " TEXT," + KEY_NAME + " TEXT," + KEY_AGE + " INTEGER," + KEY_GENDER
            + " TEXT," + KEY_HAIR + " TEXT," + KEY_EYES + " TEXT," + KEY_LOCATION
            + " TEXT," + KEY_PREFERENCES + " TEXT," + KEY_PASSWORD + " TEXT,"
            + KEY_LANGUAGE + " TEXT," + ");";

    // REQUESTLIST table create statement
    private static final String CREATE_TABLE_REQUESTLIST = "CREATE TABLE "
            + TABLE_REQUESTLIST + "(" + KEY_LOGIN + " TEXT PRIMARY KEY, " + KEY_REQUESTLOGIN
            + " TEXT, " + KEY_ANSWER + " TEXT" + ");";

    // FRIENDLIST table create statement
    private static final String CREATE_TABLE_FRIENDLIST = "CREATE TABLE "
            + TABLE_FRIENDLIST + "(" + KEY_LOGIN + " TEXT PRIMARY KEY," + KEY_FRIENDLOGIN
            + " TEXT" + ");";

    // GALLERY table create statement
    private static final String CREATE_TABLE_GALLERY = "CREATE TABLE "
            + TABLE_GALLERY + "(" + KEY_LOGIN + " TEXT PRIMARY KEY," + KEY_PICTUREID
            + " INTEGER," + KEY_PROFILEBINARY + " BOOLEAN" + ");";

    // CHAT table create statement
    private static final String CREATE_TABLE_CHAT = "CREATE TABLE "
            + TABLE_CHAT+ "(" + KEY_LOGIN + " TEXT PRIMARY KEY," + KEY_FRIENDLOGIN
            + " TEXT," + KEY_MESSAGE + " TEXT" + KEY_DATE + " DATETIME" + ");";

    // CALENDAR table create statement
    private static final String CREATE_TABLE_CALENDAR = "CREATE TABLE "
            + TABLE_CALENDAR + "(" + KEY_LOGIN + " TEXT PRIMARY KEY," + KEY_DATE
            + "DATETIME" + ");";

    // RENDEZVOUS table create statement
    private static final String CREATE_TABLE_RENDEZVOUS= "CREATE TABLE "
            + TABLE_RENDEZVOUS + "(" + KEY_LOGIN + " TEXT PRIMARY KEY," + KEY_FRIENDLOGIN
            + " TEXT," + KEY_DATE + " DATETIME" + KEY_LOCATION + " TEXT" + KEY_ANSWER
            + " BOOLEAN" + ");";


    public DatabaseHandler2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        System.out.println("In constr");
    }
//
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("On Create String First");

        // Turning on foreign keys
        db.execSQL("PRAGMA foreign_keys = ON;");
        // creating required tables
        db.execSQL("CREATE TABLE Profile (Login TEXT PRIMARY KEY, FamilyName TEXT, Name TEXT, Age INTEGER, Gender TEXT, Hair TEXT, Eyes TEXT, Location TEXT, Preferences TEXT, Password TEXT, Languages TEXT);");
        System.out.println("On Create String1");
        db.execSQL(CREATE_TABLE_RENDEZVOUS);
        System.out.println("On Create String2");
        db.execSQL("CREATE TABLE RequestList2(Login TEXT PRIMARY KEY, RequestLogin TEXT, Answer TEXT, FOREIGN KEY(Login) REFERENCES Profile(Login));");
        System.out.println("On Create String3");
        db.execSQL(CREATE_TABLE_FRIENDLIST);
        System.out.println("On Create String4");
        db.execSQL(CREATE_TABLE_CHAT);
        System.out.println("On Create String5");
        db.execSQL(CREATE_TABLE_GALLERY);
        System.out.println("On Create String6");
        db.execSQL(CREATE_TABLE_CALENDAR);

        System.out.println("On Create String7");
        //Populating tables
        db.execSQL("INSERT INTO Profile VALUES('Jojelavida','Joje','Lavida',24,'Male','Black','Blue','Madrid','Hetero','azerty54','Spanish');");
        System.out.println("On Create String8");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS Profile;");
        db.execSQL("DROP TABLE IF EXISTS RequestList;");
        db.execSQL("DROP TABLE IF EXISTS FriendList;");
        db.execSQL("DROP TABLE IF EXISTS Chat;");
        db.execSQL("DROP TABLE IF EXISTS Gallery;");
        db.execSQL("DROP TABLE IF EXISTS Calendar;");
        db.execSQL("DROP TABLE IF EXISTS Rendezvous;");
        System.out.println("On Create String onUpgrade");
        // create new tables
        onCreate(db);
    }

    /*
    * Creating a Profile
    */
    public void createProfile(Profile profile) {
        SQLiteDatabase db = this.getWritableDatabase();

        System.out.println("On Create String create Profile");

        ContentValues values = new ContentValues();
        values.put(KEY_LOGIN, profile.getLogin());
        values.put(KEY_PASSWORD, profile.getPassword());
        values.put(KEY_FAMILYNAME, "N/A");
        values.put(KEY_NAME, "N/A");
        values.put(KEY_AGE, "N/A");
        values.put(KEY_GENDER, "N/A");
        values.put(KEY_HAIR, "N/A");
        values.put(KEY_EYES, "N/A");
        values.put(KEY_LOCATION, "N/A");
        values.put(KEY_PREFERENCES, "N/A");
        values.put(KEY_PASSWORD, "N/A");
        values.put(KEY_LANGUAGE, "N/A");

        // insert row
        db.insert(TABLE_PROFILE, null, values);
        db.close();
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    //Get Profile
    public Profile getProfile(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        System.out.println("On Create String Get Profile 1");

//        String selectQuery = "SELECT * FROM Profile WHERE Login = " + login + ";";

        System.out.println("On Create String Get Profile 2");

        Cursor c = db.query("Profile", new String[] {"Login","Password"},"Login=?",new String[] {login},null, null, null, null);
//        Cursor c = db.rawQuery(selectQuery, null);

        System.out.println("On Create String Get Profile 3");

        if (c != null)
            c.moveToFirst();

        System.out.println("On Create String Get Profile 4");

        Profile pro = new Profile(c.getString(c.getColumnIndex("Login")),c.getString(c.getColumnIndex("Password")));

        c.close();
        db.close();

        System.out.println("On Create String Get Profile 8");
        return pro;
    }
}