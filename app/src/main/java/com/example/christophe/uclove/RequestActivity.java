package com.example.christophe.uclove;

/**
 * Created by Christophe on 06.05.2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class RequestActivity extends AppCompatActivity {
    ListView liste = null;
    ImageView retour;
    private Button back;

    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.request_content);

        liste = (ListView) findViewById(R.id.requestlist);

        List<String> addlist = new ArrayList<>();

        addlist.add("Requêtes entrantes");
        addlist.add("Requêtes sortantes");

        //Afficher la liste des deux éléments
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, addlist);
        liste.setAdapter(adapter);


        //2 Bouttons pour passer à la liste des requêtes
        final List<String> finalAddlist = addlist;
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view,
                                    int position,
                                    long id) {
                if(id==0){
                    Intent i = new Intent(RequestActivity.this,IncomingActivity.class);
                    startActivity(i);
                }
                else{
                    Intent i2 = new Intent(RequestActivity.this,OutgoingActivity.class);
                    startActivity(i2);
                }
            }
        });

        retour = (ImageView) findViewById(R.id.requestback);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(RequestActivity.this, MyListActivity.class);
                startActivity(i3);
            }
        });
    }
}
