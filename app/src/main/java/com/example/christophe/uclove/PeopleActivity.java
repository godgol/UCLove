package com.example.christophe.uclove;

import android.app.Activity;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
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
    public ImageButton next;
    public ImageButton like;
    public ImageButton nolike;
    int i = 0;
    List<String> array = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_content);

        gen = (TextView) findViewById(R.id.gender);
        h = (TextView) findViewById(R.id.hair);
        loc = (TextView) findViewById(R.id.location);
        ag = (TextView) findViewById(R.id.age);
        ey = (TextView) findViewById(R.id.eyes);
        pre = (TextView) findViewById(R.id.preferences);
        log = (TextView) findViewById(R.id.profile);
        random = (ImageButton) findViewById(R.id.random);
        like = (ImageButton) findViewById(R.id.like);
        nolike = (ImageButton) findViewById(R.id.nolike);

        DatabaseHandler2 db = new DatabaseHandler2(PeopleActivity.this);

        array = db.getNonFriendList(current);

        login = array.get(i);

        log.setText(login);
        loc.setText(db.readLocation(login));
        gen.setText(db.readGender(login));
        h.setText(db.readHair(login));
        ag.setText(String.valueOf(db.readAge(login)));
        ey.setText(db.readEyes(login));
        pre.setText(db.readPreferences(login));

        db.closeDB();

        //TODO Button ne marche qu'une seule fois
        next = (ImageButton) findViewById(R.id.next);
        next.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    DatabaseHandler2 db2 = new DatabaseHandler2(PeopleActivity.this);

                    log.setText(login);
                    loc.setText(db2.readLocation(login));
                    gen.setText(db2.readGender(login));
                    h.setText(db2.readHair(login));
                    ag.setText(String.valueOf(db2.readAge(login)));
                    ey.setText(db2.readEyes(login));
                    pre.setText(db2.readPreferences(login));

                    db2.closeDB();
                } else {
                    i = i + 1;
                    login = array.get(i);
                }
                return true;
            }
        });

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler2 db3 = new DatabaseHandler2(PeopleActivity.this);

                db3.createRequest(current,login);

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