package com.example.christophe.uclove;

import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Christophe on 05.05.2016.
 */
public class PeopleActivity extends AppCompatActivity {

    public String login = CurrentUser.current_user;
    /*public String gender;
    public String hair;
    public String location;
    public String age;
    public int age;
    public String eyes;
    public String preferences;*/
    public TextView log;
    public TextView gen;
    public TextView h;
    public TextView loc;
    public TextView ag;
    public TextView ey;
    public TextView pre;
    public ImageButton random;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_content);

        gen = (TextView) findViewById(R.id.gender);
        h = (TextView) findViewById(R.id.hair);
        loc = (TextView) findViewById(R.id.location);
        ag = (TextView) findViewById(R.id.age);
        ey = (TextView) findViewById(R.id.eyes);
       // pre = (TextView) findViewById(R.id.preferences);
       // log = (TextView) findViewById(R.id.profile);
       // random = (ImageButton) findViewById(R.id.random);

        DatabaseHandler2 db = new DatabaseHandler2(PeopleActivity.this);

        log.setText(login);
        gen.setText(db.readGender(login));
        h.setText(db.readHair(login));
        loc.setText(db.readLocation(login));
        ag.setText(String.valueOf(db.readAge(login)));
        ey.setText(db.readEyes(login));
        pre.setText(db.readPreferences(login));

        db.closeDB();

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                DatabaseHandler2 db2 = new DatabaseHandler2(PeopleActivity.this);



                db2.closeDB();
            }
        });

    }
}
