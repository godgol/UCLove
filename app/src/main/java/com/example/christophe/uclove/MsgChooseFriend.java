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
/*public class MsgChooseFriend extends Activity {

    ListView listView;
    ArrayAdapter<String> friendList;
    List<String> logins;
    FriendDB frd;

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend); // TODO: 05/05/2016 consulter User_Friend

        listView = (ListView) findViewById(R.id.friendList); // TODO: 05/05/2016 Consulter FriendActivity
        logins = new ArrayList<String>();

        frd = new User_Friend(this);
        frd.open();
        ArrayList<User_Friend> frdList = frd.Login; // TODO: 05/05/2016 Faire une liste d'ami
        frd.close();


        for(int i = 0; i<frdList.size(); i++){

            User_Friend user_friend = frdList.get(i);
            String sender = user_friend.getLogin1();
            String receiver = user_friend.getLogin2();
            if (sender.equals(logged_user))
                logins.add(receiver);
            else
                logins.add(sender);

        }

        friendList = new ArrayAdapter<String>(MsgChooseFriend.this, android.R.layout.simple_list_item_1,
                android.R.id.text1, logins);
        listView.setAdapter(friendList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, int pos, View view, long id){
                Controler.chat = logins.get(pos);

                Intent i = new Intent (MsgChooseFriend.this, Chat.class);
                startActivity(i);

            }

        });


    }

}
*/