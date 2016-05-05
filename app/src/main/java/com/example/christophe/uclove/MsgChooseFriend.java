package com.example.christophe.uclove;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 05/05/2016.
 */
public class MsgChooseFriend extends Activity {

    ListView listView;
    ArrayAdapter<String> friendList;
    List<String> logins;
    DatabaseHandler2 frd;
    User_Friend user_friend;

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        listView = (ListView) findViewById(R.id.friendList);
        logins = new ArrayList<String>();

        frd = new DatabaseHandler2(this);
        String[] frdList = frd.getFriendList(CurrentUser.current_user);

        System.out.println("avant la for");


        for(int i = 0; i<frdList.length; i++){

            user_friend =  new User_Friend(frd.getProfile(frdList[i]));
            String sender = CurrentUser.current_user;
            String receiver = user_friend.getLogin();
            if (sender.equals(CurrentUser.current_user))
                logins.add(receiver);
            else
                logins.add(sender);
            System.out.println("Itération"+i);

        }

        friendList = new ArrayAdapter<String>(MsgChooseFriend.this, android.R.layout.simple_list_item_1,
                android.R.id.text1, logins);
        listView.setAdapter(friendList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id){
                CurrentUser.current_chat = logins.get(pos);

                Intent i = new Intent (MsgChooseFriend.this, ChatActivity.class);
                startActivity(i);

            }

        });


    }

}
