package com.example.christophe.uclove;

import android.app.ListActivity;
import java.util.List;
import java.util.Arrays;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.content.Intent;

public class MyListActivity extends AppCompatActivity {
//    public static final String CHOSEN_TEXT = "texteChoisi";
//    List<String> someStrings = Arrays.asList("java", "scala", "prolog", "smalltalk");
//    String chosenString;
    public TextView profile;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_menu);

        profile = (TextView)findViewById(R.id.T1);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyListActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, someStrings);
//        setListAdapter(adapter);
//        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
//                chosenString = someStrings.get(position);
//                Toast.makeText(MyListActivity.this, "Vous avez choisi : " + chosenString,
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    @Override
//    public void finish() {
//        if(chosenString != null) {
//            Intent data = new Intent();
//            data.putExtra(CHOSEN_TEXT, chosenString);
//            setResult(RESULT_OK, data);
//        }
//        super.finish();
//    }
}

