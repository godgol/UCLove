package com.example.christophe.uclove;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
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
/**
 * Created by antoine on 03/05/16.
 */
public class FriendsActivity extends AppCompatActivity{
    ListView liste = null;
    private Button friendbutton;

    TextView friends;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_friends);

        liste = (ListView) findViewById(R.id.friendlist);

        List<String> exemple = new ArrayList<>();

        //exemple.add("Friend 1");

        //exemple.add("Friend 2");

        //exemple.add("Friend 3");


        //String[] fn = {"No Friends"};
        String[] name = {};
        DatabaseHandler2 db = new DatabaseHandler2(FriendsActivity.this);

        exemple.addAll(db.getFriendList("'Jojelavida'"));
        //exemple = db.getFriendList("'Jojelavida'");

        /*for(int i = 0; i<exemple.length; i++){
            //fn[i] = db.readFamilyName(exemple[i]);
            name[i] = db.readName(exemple[i]);
        }*/

        db.closeDB();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exemple);
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view,
                                    int position,
                                    long id) {
                //Log.d("Click friends", "FriendsActivity");
                Intent i = new Intent(FriendsActivity.this, FriendPanelActivity.class);
                startActivity(i);
            }
        });


        friends = (TextView) findViewById(R.id.textView);
        friends.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Intent i2 = new Intent(FriendsActivity.this, LoginActivity.class);
                    startActivity(i2);
                    return true;
                }
                else{
                    friends.setBackgroundColor(getResources().getColor(R.color.lightred));
                }
                return false;
            }
        });
    }
}
