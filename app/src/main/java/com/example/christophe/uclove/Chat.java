package com.example.christophe.uclove;

import java.lang.String;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Thomas on 03/05/2016.
 */
public class Chat extends Activity {

    private ChatArrayAdapter adp;
    private ListView list;
    private EditText chatText;
    private Button send;
    Intent in;
    private boolean side = false;

    public void onCreat(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        Intent  i = getIntent();

        send = (Button)findViewById(R.id.btn);
        list = (ListView)findViewById(R.id.ListView);
        adp = new ChatArrayAdapter(getApplicationContext(),R.layout.chat);
        chatText = (EditText)findViewById(R.id.chat);
        chatText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction()==KeyEvent.ACTION_DOWN) && (keyCode== KeyEvent.KEYCODE_ENTER)){
                    return sendChatMessage();
                }
                return false;
            }
        });

        send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                sendChatMessage();
            }
        });

        list.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        list.setAdapter(adp);

        adp.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();

                list.setSelection(adp.getCount()-1);
            }
        });





    }

    private boolean sendChatMessage(){

        adp.add(new ChatMessage(side,chatText.getText().toString()));
        chatText.setText("");
        side =!side;

        return true;
    }


}