package com.example.christophe.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christophe on 26.04.2016.
 */


//////////////////////////////////////////////////////////////////////////
//                                                                      //
//                              NOT USED                                //
//                                                                      //
//////////////////////////////////////////////////////////////////////////


public class MySQLiteOpenHelper extends SQLiteOpenHelper{

    //Nom du fichier de la BDD
    private static final String DATABASE_NAME = "databse.sqlite";
    private static final int DATABASE_VERSION = 1;
    private static Context context;
    private int i;

    public MySQLiteOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    //Méthode d'initialisation qui cree les tables de la BDD
    // Comm intuile
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS \"Profil\";");
        db.execSQL("CREATE TABLE \"Profil\"(\"Login\" TEXT PRIMARY KEY AUTOINCREMENT NOT NULL , \"Password\" TEXT);");

        db.execSQL("INSERT INTO \"Profil\" VALUES ('PaulDuChateau','azerty')");
        db.execSQL("INSERT INTO \"Profil\" VALUES ('Jojelavida','azerty54')");
        db.execSQL("INSERT INTO \"Profil\" VALUES ('vladimirkorsacof','mdpsupergénial')");
        db.execSQL("INSERT INTO \"Profil\" VALUES ('katesmith','onetwothreefourfive')");
        db.execSQL("INSERT INTO \"Profil\" VALUES ('athenazeus','onetwothreefourfivesixseveneight')");
        db.execSQL("INSERT INTO \"Profil\" VALUES ('loladu93','sevenhatenine')");
        db.execSQL("INSERT INTO \"Profil\" VALUES ('sisterlover','imissmyhand')");
        db.execSQL("INSERT INTO \"Profil\" VALUES ('obamanation','michellemabelle')");
        db.execSQL("INSERT INTO \"Profil\" VALUES ('beth','QueenForLifeMotafaqua')");
        db.execSQL("INSERT INTO \"Profil\" VALUES ('foreverrebel','DieFatherDie')");
    }

    //Ouvre la base de données
    public boolean open() {
        try{
            getReadableDatabase();
            return true;
        } catch(Throwable t){
            return false;
        }
    }

    //Supprime la table
    private void deleteDatabase(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS \"Profil\";");
    }

    //Méthode de mise à jour
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        deleteDatabase(db);
        onCreate(db);
    }


    //Méthode pour recevoir Password
    public String getPassword(String login){
        String pw = null;
        SQLiteDatabase db = getReadableDatabase();
        String whereClause = "Login =" + login;
        String[] tableColumns = new String[] {"Login", "Password"};

        Cursor c = db.query("\"Profil\"",
                tableColumns,
                whereClause,
                null,
                null,
                null,
                null);

        pw= c.getString(c.getColumnIndexOrThrow("Password"));

        return pw;
    }
}

