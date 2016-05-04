package com.example.christophe.uclove;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
public class FriendsActivity extends Activity{
    ListView liste = null;
    private Button friendbutton;

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_friends);
         liste = (ListView) findViewById(R.id.friendlist);

        List<String> exemple = new ArrayList<String>();

        exemple.add("Friend 1");

        exemple.add("Friend 2");

        exemple.add("Friend 3");

         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exemple);
        liste.setAdapter(adapter);
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view,
                                    int position,
                                    long id) {
                Log.d("Click friends", "FriendsActivity");
                Intent i = new Intent(FriendsActivity.this, FriendPanelActivity.class);
                startActivity(i);

            }
        });


    }
}
