package com.example.christophe.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Christophe on 27.04.2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper{
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
            + KEY_LANGUAGE + " TEXT," + ")";

    // REQUESTLIST table create statement
    private static final String CREATE_TABLE_REQUESTLIST = "CREATE TABLE "
            + TABLE_REQUESTLIST + "(" + KEY_LOGIN + " TEXT PRIMARY KEY," + KEY_REQUESTLOGIN
            + " TEXT," + KEY_ANSWER + " TEXT" + ")";

    // FRIENDLIST table create statement
    private static final String CREATE_TABLE_FRIENDLIST = "CREATE TABLE "
            + TABLE_FRIENDLIST + "(" + KEY_LOGIN + " TEXT PRIMARY KEY," + KEY_FRIENDLOGIN
            + " TEXT" + ")";

    // GALLERY table create statement
    private static final String CREATE_TABLE_GALLERY = "CREATE TABLE "
            + TABLE_REQUESTLIST + "(" + KEY_LOGIN + " TEXT PRIMARY KEY," + KEY_PICTUREID
            + " INTEGER," + KEY_PROFILEBINARY + " BOOLEAN" + ")";

    // CHAT table create statement
    private static final String CREATE_TABLE_CHAT = "CREATE TABLE "
            + TABLE_REQUESTLIST + "(" + KEY_LOGIN + " TEXT PRIMARY KEY," + KEY_FRIENDLOGIN
            + " TEXT," + KEY_MESSAGE + " TEXT" + KEY_DATE + " DATETIME" + ")";

    // CALENDAR table create statement
    private static final String CREATE_TABLE_CALENDAR = "CREATE TABLE "
            + TABLE_REQUESTLIST + "(" + KEY_LOGIN + " TEXT PRIMARY KEY," + KEY_DATE
            + "DATETIME" + ")";

    // RENDEZVOUS table create statement
    private static final String CREATE_TABLE_RENDEZVOUS= "CREATE TABLE "
            + TABLE_REQUESTLIST + "(" + KEY_LOGIN + " TEXT PRIMARY KEY," + KEY_FRIENDLOGIN
            + " TEXT," + KEY_DATE + " DATETIME" + KEY_LOCATION + " TEXT" + KEY_ANSWER
            + " BOOLEAN" + ")";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        System.out.println("In constr");
    }
//
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("On Create String First");

        // creating required tables
        db.execSQL("CREATE TABLE Profile (Login TEXT, FamilyName TEXT, Name TEXT, Age INTEGER, Gender TEXT, Hair TEXT, Eyes TEXT, Location TEXT, Preferences TEXT, Password TEXT, Languages TEXT)");
        System.out.println("On Create String1");
        db.execSQL(CREATE_TABLE_RENDEZVOUS);
        System.out.println("On Create String2");
        db.execSQL(CREATE_TABLE_REQUESTLIST);
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
        db.execSQL("INSERT INTO" + TABLE_PROFILE + "VALUES('Jojelavida','Joje','Lavida',24," +
                "'Male','Black','Blue','Madrid','Hetero','azerty54',''Spanish)");
        System.out.println("On Create String 8");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REQUESTLIST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRIENDLIST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHAT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GALLERY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CALENDAR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RENDEZVOUS);

        // create new tables
        onCreate(db);
    }

    /*
    * Creating a Profile
    */
    public void createProfile(Profile profile) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LOGIN, profile.getLogin());
        values.put(KEY_PASSWORD, profile.getPassword());

        // insert row
        db.insert(TABLE_PROFILE, null, values);
        db.close();
    }

    //Get Profile
    public Profile getProfile(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_PROFILE + " WHERE "
                + KEY_LOGIN + " = " + login;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Profile pro = new Profile();
        pro.setLogin(c.getString(c.getColumnIndex(KEY_LOGIN)));
        pro.setPassword((c.getString(c.getColumnIndex(KEY_PASSWORD))));

        return pro;
    }
}