package com.example.christophe.uclove;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 06/05/2016.
 */
public class AddChatActivity extends AppCompatActivity {

    ListView listView;
    List<String> nonChat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.non_chat_list);

        listView = (ListView) findViewById(R.id.newChaters);
        nonChat = new ArrayList<>();
        //String[] name = {};
        DatabaseHandler2 db = new DatabaseHandler2(this);


        nonChat = db.getFriendList(CurrentUser.current_user);

        for (int i = 0; i < nonChat.size(); i++) {

            if (!db.FriendWithMsg(CurrentUser.current_user, nonChat.get(i))) {

                nonChat.remove(i);
            }
        }
        db.closeDB();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nonChat);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view,
                                    int position,
                                    long id) {

                Intent i = new Intent(AddChatActivity.this, ChatActivity.class);
                CurrentUser.current_chat = nonChat.get(position);
                startActivity(i);
            }
        });
    }





}



