package com.example.christophe.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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
            + KEY_LANGUAGE + " TEXT" + ");";

    // REQUESTLIST table create statement
    private static final String CREATE_TABLE_REQUESTLIST = "CREATE TABLE "
            + TABLE_REQUESTLIST + "(" + KEY_LOGIN + " TEXT, " + KEY_REQUESTLOGIN
            + " TEXT, " + KEY_ANSWER + " TEXT," + " FOREIGN KEY(Login) REFERENCES Profile(Login));";

    // FRIENDLIST table create statement
    private static final String CREATE_TABLE_FRIENDLIST = "CREATE TABLE "
            + TABLE_FRIENDLIST + "(" + KEY_LOGIN + " TEXT," + KEY_FRIENDLOGIN
            + " TEXT," + " FOREIGN KEY(Login) REFERENCES Profile(Login));";

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
        db.execSQL(CREATE_TABLE_PROFILE);
        db.execSQL(CREATE_TABLE_RENDEZVOUS);
        //db.execSQL("CREATE TABLE RequestList(Login TEXT, RequestLogin TEXT, Answer TEXT, FOREIGN KEY(Login) REFERENCES Profile(Login));");
        db.execSQL(CREATE_TABLE_REQUESTLIST);
        db.execSQL(CREATE_TABLE_FRIENDLIST);
        db.execSQL(CREATE_TABLE_CHAT);
        db.execSQL(CREATE_TABLE_GALLERY);
        db.execSQL(CREATE_TABLE_CALENDAR);

        //Populating Profile table
        db.execSQL("INSERT INTO Profile VALUES(\"Jojelavida\",\"Joje\",\"Lavida\",\"24\",\"Male\",\"Black\",\"\",\"Madrid\",\"Hetero\",\"azerty54\",\"Spanish\");");
        db.execSQL("INSERT INTO Profile VALUES(\"PaulDuChateu\",\"DuChateau\",\"Paul\",\"32\",\"Male\",\"Brown\",\"Blue\",\"Berlin\",\"Hetero\",\"azerty\",\"German\");");
        db.execSQL("INSERT INTO Profile VALUES(\"vladimirkorsacof\",\"Vladimir\",\"Korsacof\",\"52\",\"Male\",\"Gray\",\"Brown\",\"\",\"Homo\",\"mdpsupergénial\",\"Russian\");");
        db.execSQL("INSERT INTO Profile VALUES(\"katesmith\",\"Kate\",\"Smith\",\"25\",\"Female\",\"Blonde\",\"Blue\",\"London\",\"Hetero\",\"onetwothreefourfive\",\"English\");");
        db.execSQL("INSERT INTO Profile VALUES(\"athenazeus\",\"Zeus\",\"Athena\",\"62\",\"Female\",\"Black\",\"Brown\",\"Athena\",\"Hetero\",\"onetwothreefourfivesixseveneight\",\"English\");");
        db.execSQL("INSERT INTO Profile VALUES(\"loladu93\",\"Alpharo\",\"Lola\",22,\"Female\",\"Black\",\"Brown\",\"Lisbonne\",\"Bi\",\"sevenhatenine\",\"English\");");
        db.execSQL("INSERT INTO Profile VALUES(\"sisterlover\",\"Lannister\",\"Jamie\",27,\"Male\",\"Blonde\",\"Brown\",\"Dubrovnik\",\"Hetero\",\"imissmyhand\",\"English\");");
        db.execSQL("INSERT INTO Profile VALUES(\"obamanation\",\"Obama\",\"Barrack\",\"56\",\"Male\",\"Gray\",\"Brown\",\"Washington\",\"Hetero\",\"michellemabelle\",\"English\");");
        db.execSQL("INSERT INTO Profile VALUES(\"beth\",\"Mary\",\"Elizabeth\",\"89\",\"Female\",\"White\",\"Green\",\"London\",\"Hetero\",\"QueenForLifeMotafaqua\",\"English\");");
        db.execSQL("INSERT INTO Profile VALUES(\"foreverrebel\",\"Organa\",\"Leia\",\"25\",\"Female\",\"Brown\",\"Brown\",\"Casablanca\",\"Hetero\",\"DIeFatherDie\",\"English\");");
        db.execSQL("INSERT INTO Profile VALUES(\"l\",\"Organa\",\"Leia\",\"25\",\"Female\",\"Brown\",\"Brown\",\"Casablanca\",\"Hetero\",\"l\",\"English\");");

        //Populating the FriendList Table
        db.execSQL("INSERT INTO FriendList VALUES (\"PaulDuChateu\",\"beth\");");
        db.execSQL("INSERT INTO FriendList VALUES (\"Jojelavida\",\"foreverrebel\");");
        db.execSQL("INSERT INTO FriendLIst VALUES (\"loladu93\",\"Jojelavida\");");
        db.execSQL("INSERT INTO FriendList VALUES (\"katesmith\",\"sisterlover\");");
        db.execSQL("INSERT INTO FriendList VALUES (\"beth\",\"obamanation\");");
        db.execSQL("INSERT INTO FriendList VALUES (\"athenazeus\",\"sisterlover\");");
        db.execSQL("INSERT INTO FriendList VALUES (\"Jojelavida\",\"katesmith\");");

        //Populating the RequestList Table
        db.execSQL("INSERT INTO RequestList VALUES (\"PaulDuChateu\",\"beth\",\"True\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"PaulDuChateu\",\"obamanation\",\"False\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"Jojelavida\",\"beth\",\"False\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"Jojelavida\",\"foreverrebel\",\"True\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"katesmith\",\"PaulDuChateu\",\"False\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"loladu93\",\"Jojelavida\",\"True\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"beth\",\"obamanation\",\"True\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"athenazeus\",\"sisterlover\",\"True\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"Jojelavida\",\"katesmith\",\"True\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"PaulDuChateu\",\"vladimirkorsacof\",\"False\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"beth\",\"vladimirkorsacof\",\"False\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"loladu93\",\"vladimirkorsacof\",\"False\");");

        /* TODO TEST IF IT WORKS
        //Populating the Calendar Table
        db.execSQL("INSERT INTO Calendar VALUES (\"PaulDuChateu\",\"2016-03-25\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"PaulDuChateu\",\"2016-04-15\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"PaulDuChateu\",\"2016-03-26\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"beth\",\"2016-03-26\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"beth\",\"2016-03-27\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"Jojelavida\",\"2016-05-15\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"Jojelavida\",\"2016-05-22\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"foreverrebel\",\"2016-05-23\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"katesmith\",\"2016-05-23\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"katesmith\",\"2016-05-24\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"sisterlover\",\"2016-05-24\");");

        //Populating the Gallery Table
        db.execSQL("INSERT INTO Gallery VALUES (\"PaulDuChateu\",\"01-0001\",\"TRUE\");");
        db.execSQL("INSERT INTO Gallery VALUES (\"PaulDuChateu\",\"01-0002\",\"FALSE\");");
        db.execSQL("INSERT INTO Gallery VALUES (\"PaulDuChateu\",\"01-0003\",\"FALSE\");");
        db.execSQL("INSERT INTO Gallery VALUES (\"Jojelavida\",\"02-0001\",\"FALSE\");");
        db.execSQL("INSERT INTO Gallery VALUES (\"Jojelavida\",\"02-0002\",\"TRUE\");");
        db.execSQL("INSERT INTO Gallery VALUES (\"Jojelavida\",\"02-0003\",\"FALSE\");");
        db.execSQL("INSERT INTO Gallery VALUES (\"foreverrebel\",\"10-0001\",\"TRUE\");");
        db.execSQL("INSERT INTO Gallery VALUES (\"foreverrebel\",\"10-0002\",\"FALSE\");");

        //Popluating the Chat Table
        db.execSQL("INSERT INTO Chat VALUES (\"PaulDuChateu\",\"beth\",\"Hey Beth! Montre tes fesses.\",\"2016-02-25 09:00:00\");");
        db.execSQL("INSERT INTO Chat VALUES (\"beth\",\"PaulDuChateau\",\"Hey Paul! Non...J'ai 86 ans.\",\"2016-02-25 09:30:00\");");
        db.execSQL("INSERT INTO Chat VALUES (\"Jojelavida\",\"foreverrebel\",\"HI\",\"2016-03-15 23:32:22\");");
        db.execSQL("INSERT INTO Chat VALUES (\"Jojelavida\",\"foreverrebel\",\"HI?\",\"2016-03-15 23:32:50\");");
        db.execSQL("INSERT INTO Chat VALUES (\"Jojelavida\",\"foreverrebel\",\"You there?\",\"2016-03-15 23:33:00\");");
        db.execSQL("INSERT INTO Chat VALUES (\"Jojelavida\",\"foreverrebel\",\"I like your Pix...\",\"2016-03-15 23:34:00\");");
        db.execSQL("INSERT INTO Chat VALUES (\"Jojelavida\",\"foreverrebel\",\"Boyfriend?\",\"2016-03-15 23:35:00\");");

        //Populating the Rendezvous Table
        db.execSQL("INSERT INTO Rendezvous VALUES (\"PaulDuChateu\",\"beth\",\"2016-03-26\",\"Beerbar\",\"TRUE\");");
        db.execSQL("INSERT INTO Rendezvous VALUES (\"katesmith\",\"sisterlover\",\"2016-05-24\",\"Bravos Bank\",\"FALSE\");");
        */

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

//        String selectQuery = "SELECT * FROM Profile WHERE Login = " + login + ";";

        Cursor c = db.query("Profile", new String[] {"Login","Password"},"Login=?",new String[] {login},null, null, null, null);
//        Cursor c = db.rawQuery(selectQuery, null);


        if (c != null)
            c.moveToFirst();


        Profile pro = new Profile(c.getString(c.getColumnIndex("Login")),c.getString(c.getColumnIndex("Password")));

        c.close();
        db.close();

        return pro;
    }

    //Updating Profile attributes
    public void updateLogin(String login, String newLogin){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Profile SET Login = " + newLogin + " WHERE Login = " + login + ";");
    }
    public void updatePassword(String login, String newPassword){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Profile SET Password = " + newPassword + " WHERE Login = " + login + ";");
    }
    public void updateFamilyName(String login, String newFN){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Profile SET FamilyName = " + newFN + " WHERE Login = " + login + ";");
    }
    public void updateName(String login, String newName){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Profile SET Name = " + newName + " WHERE Login = " + login + ";");
    }
    public void updateAge(String login, int newAge){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Profile SET Age = " + newAge + " WHERE Login = " + login + ";");
    }
    public void updateGender(String login, String newGender){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Profile SET Gender = " + newGender + " WHERE Login = " + login + ";");
    }
    public void updateLocation(String login, String newLocation){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Profile SET Location = " + newLocation + " WHERE Login = " + login + ";");
    }
    public void updateHair(String login, String newHair){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Profile SET Hair = " + newHair + " WHERE Login = " + login + ";");
    }
    public void updateEyes(String login, String newEyes){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Profile SET Eyes = " + newEyes + " WHERE Login = " + login + ";");
    }
    public void updatePreferences(String login, String newPreferences){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Profile SET Preferences = " + newPreferences + " WHERE Login = " + login + ";");
    }
    public void updateLanguage(String login, String newLanguage){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Profile SET Language = " + newLanguage + " WHERE Login = " + login + ";");
    }

    //Reading Profile attributes
    public String readPassword(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query("Profile", new String[] {"Password"},"Login=?",new String[] {login},null, null, null, null);

        if (c != null)
            c.moveToFirst();

        String password = c.getString(c.getColumnIndex("Password"));

        c.close();
        db.close();

        return password;
    }

    public String readFamilyName(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query("Profile", new String[]{"FamilyName"}, "Login=?", new String[]{login}, null, null, null, null);

        if (c != null)
            c.moveToFirst();

        String fn = c.getString(c.getColumnIndex("FamilyName"));

        c.close();
        db.close();

        return fn;
    }

    public String readName(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query("Profile", new String[]{"Name"}, "Login=?", new String[]{login}, null, null, null, null);

        if (c != null)
            c.moveToFirst();

        String name = c.getString(c.getColumnIndex("Name"));

        c.close();
        db.close();

        return name;
    }

    public int readAge(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query("Profile", new String[]{"Age"}, "Login=?", new String[]{login}, null, null, null, null);

        if (c != null)
            c.moveToFirst();

        int age = c.getInt(c.getColumnIndex("Name"));

        c.close();
        db.close();

        return age;
    }

    public String readGender(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query("Profile", new String[]{"Gender"}, "Login=?", new String[]{login}, null, null, null, null);

        if (c != null)
            c.moveToFirst();

        String gender = c.getString(c.getColumnIndex("Gender"));

        c.close();
        db.close();

        return gender;
    }

    public String readLocation(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query("Profile", new String[]{"Location"}, "Login=?", new String[]{login}, null, null, null, null);

        if (c != null)
            c.moveToFirst();

        String location = c.getString(c.getColumnIndex("Location"));

        c.close();
        db.close();

        return location;
    }

    public String readHair(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query("Profile", new String[]{"Hair"}, "Login=?", new String[]{login}, null, null, null, null);

        if (c != null)
            c.moveToFirst();

        String hair = c.getString(c.getColumnIndex("Hair"));

        c.close();
        db.close();

        return hair;
    }

    public String readEyes(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query("Profile", new String[]{"Eyes"}, "Login=?", new String[]{login}, null, null, null, null);

        if (c != null)
            c.moveToFirst();

        String eyes = c.getString(c.getColumnIndex("Eyes"));

        c.close();
        db.close();

        return eyes;
    }

    public String readPreferences(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query("Profile", new String[]{"Preferences"}, "Login=?", new String[]{login}, null, null, null, null);

        if (c != null)
            c.moveToFirst();

        String preferences = c.getString(c.getColumnIndex("Preferences"));

        c.close();
        db.close();

        return preferences;
    }

    public String readLanguage(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query("Profile", new String[]{"Language"}, "Login=?", new String[]{login}, null, null, null, null);

        if (c != null)
            c.moveToFirst();

        String language = c.getString(c.getColumnIndex("Language"));

        c.close();
        db.close();

        return language;
    }


    /*
    * Creating a Friend
    */
    public void createFriend(String login, String FriendLogin) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_LOGIN, login);
        values.put(KEY_FRIENDLOGIN, FriendLogin);

        // insert row
        db.insert(TABLE_FRIENDLIST, null, values);
        db.close();
    }

    //Deleting a friend
    public void DeleteFriend(String FriendLogin) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_FRIENDLIST, KEY_FRIENDLOGIN + " = ?", new String[]{FriendLogin});

        db.close(); // Closing database connection
    }

    //Getting FriendList of a user
    public List<String> getFriendList(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query("FriendList", new String[]{"FriendLogin"}, "Login=?", new String[]{login}, null, null, null, null);

        List<String> list = new ArrayList<String>();
        //String array[] = new String[c.getCount()];
        //int i = 0;

        if (c != null)
            c.moveToFirst();
        /*while (!c.isAfterLast()) {
            list.add(c.getString(c.getColumnIndex("FriendLogin")));
            i++;
            c.moveToNext();
        }*/
        while (c.moveToNext()) {
            list.add(c.getString(c.getColumnIndex("FriendLogin")));
        }

        c.close();
        db.close();

        return list;
    }


    /*
    * Creating a Request
    */
    public void createRequest(String login, String RequestLogin) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LOGIN, login);
        values.put(KEY_REQUESTLOGIN, RequestLogin);
        values.put(KEY_ANSWER, "False");

        // insert row
        db.insert(TABLE_REQUESTLIST, null, values);
        db.close();
    }

    //Deleting a Request
    public void DeleteRequest(String RequestLogin) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_REQUESTLIST, KEY_REQUESTLOGIN + " = ?", new String[]{RequestLogin});

        db.close(); // Closing database connection
    }

    //Getting RequestList of a user
    public List<String> getRequestList(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query("RequestList", new String[]{"RequestLogin"}, "Login=?", new String[]{login}, null, null, null, null);

        List<String> list = new ArrayList<String>();
        //String array[] = new String[c.getCount()];
        //int i = 0;

        if (c != null)
            c.moveToFirst();
        /*while (!c.isAfterLast()) {
            list.add(c.getString(c.getColumnIndex("FriendLogin")));
            i++;
            c.moveToNext();
        }*/
        while (c.moveToNext()) {
            list.add(c.getString(c.getColumnIndex("RequestLogin")));
        }

        c.close();
        db.close();

        return list;
    }

    //TODO Test if it works
    /*
    * Adding a Pic
    */
    public void addPic(String login, String PicID) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LOGIN, login);
        values.put(KEY_PICTUREID, PicID);
        values.put(KEY_PROFILEBINARY, "FALSE");

        // insert row
        db.insert(TABLE_GALLERY, null, values);
        db.close();
    }

    //Deleting a Picture
    public void DeletePicture(String PicID) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_GALLERY, KEY_PICTUREID + " = ?", new String[]{PicID});

        db.close(); // Closing database connection
    }

    public List<String> readPictureID(String login) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query("Gallery", new String[]{"PictureID"}, "Login=?", new String[]{login}, null, null, null, null);

        List<String> list = new ArrayList<String>();

        if (c != null)
            c.moveToFirst();


        while (c.moveToNext()) {
            list.add(c.getString(c.getColumnIndex("RequestLogin")));
        }
        c.close();
        db.close();

        return list;
    }

    public String readPicBin(String login, String PicID) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query("Gallery", new String[]{"ProfileBinary"}, "PicID=? AND Login=?", new String[]{PicID, login}, null, null, null, null);

        if (c != null)
            c.moveToFirst();

        String profBin = c.getString(c.getColumnIndex("ProfileBinary"));

        c.close();
        db.close();

        return profBin;
    }

    /* TODO Methods to write
    *
    // CHAT Table - column names
    private static final String KEY_MESSAGE = "Message";
    private static final String KEY_DATE = "Date";

    //CALENDAR Table - column names
    //Uses Login and Date

    // RENDEZVOUS Table - column names
    // Uses Login, FriendLogin, Date, Location, Answer
    *
    * */
}