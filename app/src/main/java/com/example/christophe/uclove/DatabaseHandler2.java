package com.example.christophe.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
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
            + TABLE_GALLERY + "(" + KEY_LOGIN + " TEXT," + KEY_PICTUREID
            + " INTEGER," + KEY_PROFILEBINARY + " BOOLEAN" + ");";

    // CHAT table create statement
    private static final String CREATE_TABLE_CHAT = "CREATE TABLE "
            + TABLE_CHAT+ " (" + KEY_LOGIN + " TEXT," + KEY_FRIENDLOGIN
            + " TEXT," + KEY_MESSAGE + " TEXT," + KEY_DATE + " TEXT" + ");";

    // CALENDAR table create statement
    private static final String CREATE_TABLE_CALENDAR = "CREATE TABLE "
            + TABLE_CALENDAR + "(" + KEY_LOGIN + " TEXT," + KEY_DATE
            + "TEXT" + ");";

    // RENDEZVOUS table create statement
    private static final String CREATE_TABLE_RENDEZVOUS= "CREATE TABLE "
            + TABLE_RENDEZVOUS + "(" + KEY_LOGIN + " TEXT PRIMARY KEY," + KEY_FRIENDLOGIN
            + " TEXT," + KEY_DATE + " TEXT," + KEY_LOCATION + " TEXT," + KEY_ANSWER
            + " TEXT" + ");";


    public DatabaseHandler2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        System.out.println("In constr");
    }

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
        db.execSQL("INSERT INTO Profile VALUES(\"PaulDuChateau\",\"DuChateau\",\"Paul\",\"32\",\"Male\",\"Brown\",\"Blue\",\"Berlin\",\"Hetero\",\"azerty\",\"German\");");
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
        db.execSQL("INSERT INTO FriendList VALUES (\"PaulDuChateau\",\"beth\");");
        db.execSQL("INSERT INTO FriendList VALUES (\"Jojelavida\",\"foreverrebel\");");
        db.execSQL("INSERT INTO FriendLIst VALUES (\"loladu93\",\"Jojelavida\");");
        db.execSQL("INSERT INTO FriendList VALUES (\"katesmith\",\"sisterlover\");");
        db.execSQL("INSERT INTO FriendList VALUES (\"beth\",\"obamanation\");");
        db.execSQL("INSERT INTO FriendList VALUES (\"athenazeus\",\"sisterlover\");");
        db.execSQL("INSERT INTO FriendList VALUES (\"Jojelavida\",\"katesmith\");");

        //Populating the RequestList Table
        db.execSQL("INSERT INTO RequestList VALUES (\"PaulDuChateau\",\"beth\",\"True\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"PaulDuChateau\",\"obamanation\",\"False\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"Jojelavida\",\"beth\",\"False\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"Jojelavida\",\"foreverrebel\",\"True\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"katesmith\",\"PaulDuChateau\",\"False\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"loladu93\",\"Jojelavida\",\"None\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"beth\",\"obamanation\",\"True\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"athenazeus\",\"sisterlover\",\"True\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"Jojelavida\",\"katesmith\",\"True\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"PaulDuChateau\",\"vladimirkorsacof\",\"None\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"beth\",\"vladimirkorsacof\",\"False\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"loladu93\",\"vladimirkorsacof\",\"None\");");
        db.execSQL("INSERT INTO RequestList VALUES (\"Jojelavida\",\"PaulDuChateau\",\"None\");");

        //Populating the Calendar Table
        db.execSQL("INSERT INTO Calendar VALUES (\"PaulDuChateau\",\"2016-3-25 12:00\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"PaulDuChateau\",\"2016-4-15 15:00\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"PaulDuChateau\",\"2016-3-26 21:00\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"beth\",\"2016-3-26 21:00\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"beth\",\"2016-3-27 15:00\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"Jojelavida\",\"2016-5-15 16:00\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"Jojelavida\",\"2016-5-22 19:00\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"foreverrebel\",\"2016-5-23 20:00\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"katesmith\",\"2016-5-23 20:00\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"katesmith\",\"2016-5-24 16:00\");");
        db.execSQL("INSERT INTO Calendar VALUES (\"sisterlover\",\"2016-5-24 16:00\");");

        //Populating the Gallery Table
        db.execSQL("INSERT INTO Gallery VALUES (\"PaulDuChateau\",\"01-0001\",\"TRUE\");");
        db.execSQL("INSERT INTO Gallery VALUES (\"PaulDuChateau\",\"01-0002\",\"FALSE\");");
        db.execSQL("INSERT INTO Gallery VALUES (\"PaulDuChateau\",\"01-0003\",\"FALSE\");");
        db.execSQL("INSERT INTO Gallery VALUES (\"Jojelavida\",\"02-0001\",\"FALSE\");");
        db.execSQL("INSERT INTO Gallery VALUES (\"Jojelavida\",\"02-0002\",\"TRUE\");");
        db.execSQL("INSERT INTO Gallery VALUES (\"Jojelavida\",\"02-0003\",\"FALSE\");");
        db.execSQL("INSERT INTO Gallery VALUES (\"foreverrebel\",\"10-0001\",\"TRUE\");");
        db.execSQL("INSERT INTO Gallery VALUES (\"foreverrebel\",\"10-0002\",\"FALSE\");");

        //Popluating the Chat Table*/
        db.execSQL("INSERT INTO Chat VALUES (\"PaulDuChateau\",\"beth\",\"Hey Beth! Montre tes fesses.\",\"09:00\");");
        db.execSQL("INSERT INTO Chat VALUES (\"beth\",\"PaulDuChateau\",\"Hey Paul! Non...J'ai 86 ans.\",\"09:30\");");
        db.execSQL("INSERT INTO Chat VALUES (\"Jojelavida\",\"foreverrebel\",\"HI\",\"23:32\");");
        db.execSQL("INSERT INTO Chat VALUES (\"Jojelavida\",\"foreverrebel\",\"HI?\",\"23:32\");");
        db.execSQL("INSERT INTO Chat VALUES (\"Jojelavida\",\"foreverrebel\",\"You there?\",\"23:33\");");
        db.execSQL("INSERT INTO Chat VALUES (\"Jojelavida\",\"foreverrebel\",\"I like your Pix...\",\"23:34\");");
        db.execSQL("INSERT INTO Chat VALUES (\"Jojelavida\",\"foreverrebel\",\"Boyfriend?\",\"23:35\");");

        //Populating the Rendezvous Table
        db.execSQL("INSERT INTO Rendezvous VALUES (\"PaulDuChateau\",\"beth\",\"2016-3-26 21:00\",\"Beerbar\",\"TRUE\");");
        db.execSQL("INSERT INTO Rendezvous VALUES (\"katesmith\",\"sisterlover\",\"2016-5-24 16:00\",\"Bravos Bank\",\"FALSE\");");


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

//      String selectQuery = "SELECT * FROM Profile WHERE Login = " + login + ";";

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

        db.close();
    }
    public void updatePassword(String login, String newPassword){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("UPDATE Profile SET Password = " + newPassword + " WHERE Login = " + login + ";");
        ContentValues newValues = new ContentValues();
        newValues.put("Password", newPassword);

        String[] args = new String[]{login};
        db.update("Profile", newValues, "Login=?", args);

        db.close();
    }
    public void updateFamilyName(String login, String newFN){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("UPDATE Profile SET FamilyName = " + newFN + " WHERE Login = " + login + ";");
        ContentValues newValues = new ContentValues();
        newValues.put("FamilyName", newFN);

        String[] args = new String[]{login};
        db.update("Profile", newValues, "Login=?", args);

        db.close();
    }
    public void updateName(String login, String newName){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("UPDATE Profile SET Name = " + newName + " WHERE Login = " + login + ";");
        ContentValues newValues = new ContentValues();
        newValues.put("Name", newName);

        String[] args = new String[]{login};
        db.update("Profile", newValues, "Login=?", args);

        db.close();
    }
    public void updateAge(String login, int newAge){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("UPDATE Profile SET Age = " + newAge + " WHERE Login = " + login + ";");
        ContentValues newValues = new ContentValues();
        newValues.put("Age", newAge);

        String[] args = new String[]{login};
        db.update("Profile", newValues, "Login=?", args);

        db.close();
    }
    public void updateGender(String login, String newGender){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("UPDATE Profile SET Gender = " + newGender + " WHERE Login = " + login + ";");
        ContentValues newValues = new ContentValues();
        newValues.put("Gender", newGender);

        String[] args = new String[]{login};
        db.update("Profile", newValues, "Login=?", args);
        db.close();
    }
    public void updateLocation(String login, String newLocation){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("UPDATE Profile SET Location = " + newLocation + " WHERE Login = " + login + ";");
        ContentValues newValues = new ContentValues();
        newValues.put("Location", newLocation);

        String[] args = new String[]{login};
        db.update("Profile", newValues, "Login=?", args);

        db.close();
    }
    public void updateHair(String login, String newHair){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("UPDATE Profile SET Hair = " + newHair + " WHERE Login = " + login + ";");
        ContentValues newValues = new ContentValues();
        newValues.put("Hair", newHair);

        String[] args = new String[]{login};
        db.update("Profile", newValues, "Login=?", args);

        db.close();
    }
    public void updateEyes(String login, String newEyes){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("UPDATE Profile SET Eyes = " + newEyes + " WHERE Login = " + login + ";");
        ContentValues newValues = new ContentValues();
        newValues.put("Eyes", newEyes);

        String[] args = new String[]{login};
        db.update("Profile", newValues, "Login=?", args);

        db.close();
    }
    public void updatePreferences(String login, String newPreferences){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("UPDATE Profile SET Preferences = " + newPreferences + " WHERE Login = " + login + ";");
        ContentValues newValues = new ContentValues();
        newValues.put("Preferences", newPreferences);

        String[] args = new String[]{login};
        db.update("Profile", newValues, "Login=?", args);

        db.close();
    }
    public void updateLanguage(String login, String newLanguage){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("UPDATE Profile SET Language = " + newLanguage + " WHERE Login = " + login + ";");
        ContentValues newValues = new ContentValues();
        newValues.put("Language", newLanguage);

        String[] args = new String[]{login};
        db.update("Profile", newValues, "Login=?", args);

        db.close();
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

        int age = c.getInt(c.getColumnIndex("Age"));

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

        Cursor c = db.query("Profile", new String[] {"Location"}, "Login=?", new String[] {login}, null, null, null, null);

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

        //Get all friends you added
        Cursor c = db.query("FriendList", new String[]{"FriendLogin"}, "Login=?", new String[]{login}, null, null, null, null);

        if (c != null)
            c.moveToFirst();

        List<String> array = new ArrayList<>();
        do{
            String uname = c.getString(c.getColumnIndex("FriendLogin"));
            array.add(uname);
        }while(c.moveToNext());

        c.close();

        //Get all friends that added you
        Cursor c2 = db.query("FriendList", new String[]{"Login"}, "FriendLogin=?", new String[]{login}, null, null, null, null);

        if (c2 != null)
            c2.moveToFirst();

        do{
            String uname = c.getString(c.getColumnIndex("Login"));
            array.add(uname);
        }while(c2.moveToNext());

        c2.close();

        db.close();

        return array;
    }

    public boolean FriendWithMsg(String login, String friendLogin) {
        SQLiteDatabase db = this.getReadableDatabase();

        boolean empty = true;
        Cursor c = db.query("Chat", new String[]{"Message"}, "Login=? AND FriendLogin=?", new String[]{login,friendLogin}, null, null, null, null);

        if (c != null)
            c.moveToFirst();


        if(c.getCount()!=0){
           empty=false;
        }

        c.close();
        db.close();

        return empty;
    }

    public List<String> getAllLogins(String login){
        SQLiteDatabase db = this.getReadableDatabase();

        List<String> list = new ArrayList<>();
        Cursor c = db.query("Profile", new String[]{"Login"}, "Login !=?", new String[] {login}, null, null, null, null); //Get all Logins but ours

        int i = 0;
        if (c != null)
            c.moveToFirst();

        do{
            list.add(c.getString(c.getColumnIndex("Login")));
            i++;
        }while (c.moveToNext());
        c.close();
        db.close();

        return list;
    }

    public List<String> getNonFriendList(String login){
        SQLiteDatabase db = this.getReadableDatabase();

        List<String> nonFriends = new ArrayList<>();
        List<String> logs = getAllLogins(login);
        List<String> friends = getFriendList(login);

       for(int j = 0; j<logs.size(); j++){
           if(!friends.contains(logs.get(j))){
                nonFriends.add(logs.get(j));
           }
        }
        return nonFriends;
    }

    /*
    * Creating a Request
    */
    public void createRequest(String login, String RequestLogin, String etat) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LOGIN, login);
        values.put(KEY_REQUESTLOGIN, RequestLogin);
        values.put(KEY_ANSWER, etat);

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

    public void add(Message msg) {

        SQLiteDatabase mDB = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(KEY_LOGIN, msg.getSender());
        val.put(KEY_FRIENDLOGIN, msg.getReceiver());
        val.put(KEY_MESSAGE, msg.getMessage());
        val.put(KEY_DATE, msg.getTime());
        mDB.insert(TABLE_CHAT, null, val);


        mDB.close();
    }

    public ArrayList<Message> Conversation(String sender, String receiver) {

        SQLiteDatabase mDB = this.getWritableDatabase();
        String bubble = "select * from " + TABLE_CHAT
                + " where ( Login = \"" + sender + "\" or Login = \"" + receiver + "\")" +
                " and ( FriendLogin = \"" + sender + "\" or FriendLogin = \"" + receiver + "\");";

        Cursor cursor = mDB.rawQuery(bubble, new String[]{});

        ArrayList<Message> list = new ArrayList<Message>();

        if (cursor != null)
            cursor.moveToFirst();

            do {

                Message message = new Message();

                message.setSender(cursor.getString(0));
                message.setReceiver(cursor.getString(1));
                message.setMessage(cursor.getString(2));
                message.setTime(cursor.getString(3));
                list.add(message);
            }
            while (cursor.moveToNext());
        cursor.close();
        mDB.close();
        return list;

    }

    public List<RDV> getRDV(String login, String FriendLogin){
        ArrayList<RDV> list = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();

        String bubble = "select * from " + TABLE_RENDEZVOUS
                + " where ( Login = \"" + login + "\" AND FriendLogin = \"" + FriendLogin + "\");";

        Cursor cursor = db.rawQuery(bubble,new String[]{});

        if(cursor.getCount()!=0) {
            if (cursor != null)
                cursor.moveToFirst();
            do {
                RDV rdv = new RDV();

                rdv.setSender(cursor.getString(0));
                rdv.setReceiver(cursor.getString(1));
                rdv.setDate(cursor.getString(2));
                rdv.setLocation(cursor.getString(3));
                rdv.setEtat(cursor.getString(4));

                list.add(rdv);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public void createRDV(RDV rdv){
        SQLiteDatabase mDB = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(KEY_LOGIN, rdv.getSender());
        val.put(KEY_FRIENDLOGIN, rdv.getReceiver());
        val.put(KEY_DATE, rdv.getDate());
        val.put(KEY_ANSWER, rdv.getEtat());
        val.put(KEY_LOCATION, rdv.getLocation());

        mDB.insert(TABLE_RENDEZVOUS, null, val);

        mDB.close();
    }

    public List<Date_Dispo> getDateDispo(String login){
        ArrayList<Date_Dispo> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        String bubble = "select * from " + TABLE_CALENDAR + " whereLogin = \"" + login + "\" ;";

        Cursor cursor = db.rawQuery(bubble,new String[]{});

        if(cursor.getCount()!=0) {
            if (cursor != null)
                cursor.moveToFirst();
            do {
                Date_Dispo date = new Date_Dispo();

                date.setUser(cursor.getString(0));
                date.setDate(cursor.getString(1));

                list.add(date);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public void createDateDispo(Date_Dispo date){
        SQLiteDatabase mDB = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(KEY_LOGIN, date.getUser());
        val.put(KEY_DATE, date.getDate());

        mDB.insert(TABLE_CALENDAR, null, val);

        mDB.close();
    }

    public void updateRequestEtat(String login, String FriendLogin, String etat){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues newValues = new ContentValues();
        newValues.put("Answer", etat);

        String[] args = new String[]{login, FriendLogin};
        db.update("RequestList", newValues, "Login=? AND RequestLogin=?", args);


        db.close();
    }

    public String getEtatRequest(String login, String FriendLogin){
        SQLiteDatabase db = this.getWritableDatabase();

        System.out.println("Test Update");
        Cursor c = db.query("RequestList", new String[] {"Answer"},"Login=? AND RequestLogin=?",new String[] {login,FriendLogin},null, null, null, null);

        if (c != null)
            c.moveToFirst();

        System.out.println("Test Update après");
        String etat = c.getString(c.getColumnIndex("Answer"));

        System.out.println("Test Update après 2");
        c.close();
        db.close();

        return etat;
    }

}