package com.example.christophe.uclove;

import android.app.Activity;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christophe on 05.05.2016.
 */
public class PeopleActivity extends AppCompatActivity {

    public String current = CurrentUser.current_user;
    public String login;
    public TextView log;
    public TextView gen;
    public TextView h;
    public TextView loc;
    public TextView ag;
    public TextView ey;
    public TextView pre;
    public ImageButton random;
    public ImageView like;
    public ImageView nolike;
    int i = 0;
    List<String> array = new ArrayList<>();
    //List<String> arrayDeleted = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_content);

        //initialiser les TextView et les ImageButton
        gen = (TextView) findViewById(R.id.gender);
        h = (TextView) findViewById(R.id.hair);
        loc = (TextView) findViewById(R.id.location);
        ag = (TextView) findViewById(R.id.age);
        ey = (TextView) findViewById(R.id.eyes);
        pre = (TextView) findViewById(R.id.preferences);
        log = (TextView) findViewById(R.id.profile);
        random = (ImageButton) findViewById(R.id.random);
        like = (ImageView) findViewById(R.id.like);
        nolike = (ImageView) findViewById(R.id.nolike);

        DatabaseHandler2 db = new DatabaseHandler2(PeopleActivity.this);

        System.out.println("TEst");
        array = db.getNonFriendList(current);

        /* Ce bout de code permettrait de supprimer tous les non-amis qui ont déjà recu une
        requête auparavant qui a été denied.
        //Déselectionner ceux qui ont l'état Request None
        for(int j = 0; j<array.size(); j++){
            if(db.getEtatRequest(current,array.get(j)).equals("None")){
                arrayDeleted.add(array.get(j));
                System.out.println("TEst"+j);
            }
        }
        System.out.println("TEst après");*/

        //Adapter les Textview pour le premier user non amis du current user.

        login = array.get(i);

        log.setText(login);
        loc.setText(db.readLocation(login));
        gen.setText(db.readGender(login));
        h.setText(db.readHair(login));
        ag.setText(String.valueOf(db.readAge(login)));
        ey.setText(db.readEyes(login));
        pre.setText(db.readPreferences(login));

        db.closeDB();

        //Envoyer une requête et créer celle-ci dans la BD et passer à l'utilisateur suivant.
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler2 db3 = new DatabaseHandler2(PeopleActivity.this);

                db3.createRequest(current, login, "true");

                i = i + 1;
                login = array.get(i);

                log.setText(login);
                loc.setText(db3.readLocation(login));
                gen.setText(db3.readGender(login));
                h.setText(db3.readHair(login));
                ag.setText(String.valueOf(db3.readAge(login)));
                ey.setText(db3.readEyes(login));
                pre.setText(db3.readPreferences(login));

                db3.closeDB();
            }
        });

        //Deny le user et mettre l'état de la requête à FALSE--Ensuite passer au prochain user.
        nolike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler2 db3 = new DatabaseHandler2(PeopleActivity.this);

                db3.createRequest(current,login,"false");

                i = i + 1;
                login = array.get(i);

                log.setText(login);
                loc.setText(db3.readLocation(login));
                gen.setText(db3.readGender(login));
                h.setText(db3.readHair(login));
                ag.setText(String.valueOf(db3.readAge(login)));
                ey.setText(db3.readEyes(login));
                pre.setText(db3.readPreferences(login));

                db3.closeDB();
            }
        });
    }

}