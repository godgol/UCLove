package com.example.christophe.uclove;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.StringDef;
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
public class ChatActivity extends Activity {

    ListView listView;
    List<String> messages;
    ArrayAdapter<String> messageAdapter;
    DBChat dbChat;

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        listView = (ListView)findViewById(R.id.ListView);
        messages = new ArrayList<String>();

        dbChat = new DBChat(this);
        dbChat.open();
        ArrayList<Message> msgList = dbChat.Conversation(CurrentUser.current_user, CurrentUser.current_chat);
        dbChat.close();

        for(int i = 0; i<msgList.size(); i++){

            Message conversation = msgList.get(i);
            messages.add(conversation.getSender() + "                    " + conversation.getTime());

            messages.add(conversation.getMessage());
            messages.add("");
        }

        messageAdapter = new ArrayAdapter<String>(ChatActivity.this, android.R.layout.simple_list_item_1,
                android.R.id.text1, messages);
        listView.setAdapter(messageAdapter);

        final EditText editMessage = (EditText)findViewById(R.id.chat);
        Button send = (Button)findViewById(R.id.btn);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = editMessage.getText().toString();
                String date = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
                if (msg.length() > 0) {

                    editMessage.setText("");
                    messages.add(CurrentUser.current_user + "                    " + date);
                    messages.add(msg);
                    messages.add("");

                    Message message = new Message();
                    message.setMessage(msg);
                    message.setSender(CurrentUser.current_user);
                    message.setReceiver(CurrentUser.current_chat);
                    message.setTime(date);

                    dbChat.open();
                    dbChat.add(message);
                    dbChat.close();

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
