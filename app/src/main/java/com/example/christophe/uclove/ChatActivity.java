package com.example.christophe.uclove;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Thomas on 05/05/2016.
 */
public class ChatActivity extends AppCompatActivity {

    ListView listView;
    List<String> messages;
    ArrayAdapter<String> messageAdapter;
    ArrayList<Message> msgList;


    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_main);
        DatabaseHandler2 mDB = new DatabaseHandler2(this);

        listView = (ListView)findViewById(R.id.ListView);


        messages = new ArrayList<String>();

        if(mDB.Conversation(CurrentUser.current_user, CurrentUser.current_chat) != null) {
            msgList = mDB.Conversation(CurrentUser.current_user, CurrentUser.current_chat);

            for (int i = 0; i < msgList.size(); i++) {

                messages.add(msgList.get(i).getSender() + ": " + msgList.get(i).getMessage());

            }


            mDB.closeDB();
        }

        if (messages != null) {

        /*for(int i = 0; i<messages.size(); i++){

            Message conversation = messages.get(i);
            messages.add(conversation);
        }*/

            messageAdapter = new ArrayAdapter<String>(ChatActivity.this, android.R.layout.simple_list_item_1,
                    android.R.id.text1, messages);
            listView.setAdapter(messageAdapter);
        }

        final EditText editMessage = (EditText)findViewById(R.id.chat);
        Button send = (Button)findViewById(R.id.btn);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = editMessage.getText().toString();
                String date = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
                Message m = new Message(date, msg, CurrentUser.current_chat, CurrentUser.current_user);
                if (msg.length() > 0) {

                    editMessage.setText("");
                    msgList.add(m);
                    //msgList.add(msg);
                    //msgList.add("");

                    messages.add(msgList.get(msgList.size()-1).getSender()+": "+msgList.get(msgList.size()-1).getMessage());


                    DatabaseHandler2 mDB2 = new DatabaseHandler2(ChatActivity.this);
                    mDB2.add(m);
                    mDB2.closeDB();


                    messageAdapter = new ArrayAdapter<String>(ChatActivity.this, android.R.layout.simple_list_item_1,
                            android.R.id.text1, messages);
                    listView.setAdapter(messageAdapter);

                }
                else
                    Toast.makeText(ChatActivity.this, "Minimum un charactere", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
