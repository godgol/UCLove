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
public class MySQLiteOpenHelper extends SQLiteOpenHelper{

    //Nom du fichier de la BDD
    private static final String DATABASE_NAME = "database.sqlite";

    private static final int DATABASE_VERSION = 1;
    private static Context context;
    private int i;

    public MySQLiteOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    //Méthode d'initialisation qui cree les tables de la BDD
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS \"languages\";");
        db.execSQL("CREATE TABLE \"languages\" (\"l_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , \"l_name\" TEXT);");
    }

    //Ouvre la base de données
    public boolean open() {
        try{
            getWritableDatabase();
            return true;
        } catch(Throwable t){
            return false;
        }
    }

    //Supprime la table
    private void deleteDatabase(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS \"languages\";");
    }

    //Méthode de mise à jour
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        deleteDatabase(db);
        onCreate(db);
    }

    //Méthode pour renvoyer le string des languages
    public List<String> getLanguages() {
        List<String> languages = new ArrayList<String>();
        SQLiteDatabase db = getReadableDatabase();
        //Résultats de la requête sont mis dans un cursor
        Cursor c = db.query("\"languages\"",
                new String[]{"\"l_id\"", "\"l_name\""},
                null, //Colonnes pour la clause WHERE
                null, //Valeurs pour la clause WHERE
                null, //GROUP BY
                null, //ne pas filtrer par groupe de ligne
                null  //pas d'ordre
        );
        if(c.moveToFirst()){
            for(int i = 0; i < c.getCount(); i++){
                String s = c.getString(c.getColumnIndexOrThrow("l_name"));
                languages.add(s);
                c.moveToNext();
            }
        }
        c.close();
        return languages;
    }
}

