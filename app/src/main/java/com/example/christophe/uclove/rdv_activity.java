package com.example.christophe.uclove;

import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.lang.String;

/**
 * Created by antoine on 06/05/16.
 */

public class rdv_activity extends AppCompatActivity {
    String year;
    String month;
    String day;
    String current = CurrentUser.current_user;
    String year_rdv;
    String month_rdv;
    String day_rdv;
    ListView liste;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_rdv_panel);

        liste = (ListView) findViewById(R.id.rdv_list);


        //Recevoir les extras de l'intent
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            year = extras.getString("year");
            month = extras.getString("month");
            day = extras.getString("day");
        }

        //Recevoir les RDV de la BD
        DatabaseHandler2 db = new DatabaseHandler2(rdv_activity.this);
        List<RDV> rdv = db.getRDV(current);
        System.out.println("fin db");
        List<RDV> new_rdv = new ArrayList<RDV>();
        List<String> rdv_string = new ArrayList<String>();

        if(rdv==null)
        {
            List<String> no_rdv = new ArrayList<>();
            no_rdv.add("Pas de rdv");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, no_rdv);
            liste.setAdapter(adapter);
        }
        else {
            System.out.println(rdv.size());
            for (int i = 0; i < rdv.size(); i++) {
                String[] data = rdv.get(i).getDate().split("-");
                String[] data2 = data[2].split(" ");
                System.out.println(year);
                System.out.println(data[0]);
                System.out.println(month);
                System.out.println(data[1]);
                System.out.println(day);
                System.out.println(data2[0]);
                if (year.equals(data[0]) && month.equals(data[1]) && day.equals(data2[0])) {
                    new_rdv.add(rdv.get(i));
                }

            }
            if(new_rdv.size()==0)
            {
                rdv_string.add("Pas de rdv à cette date");
            }

            for (int i = 0; i < new_rdv.size(); i++) {
                rdv_string.add(new_rdv.toString());
            }

            db.closeDB();
            System.out.println("Test2");

            //Afficher le RDV comme liste
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rdv_string);
            liste.setAdapter(adapter);
        }





    }
}
