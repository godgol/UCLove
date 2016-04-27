package com.example.christophe.uclove;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
//    private static final int REQUEST_CODE = 1;
//    private TextView currentSelection;
    private Button selectItemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
//        currentSelection = (TextView) findViewById(R.id.current_selection);
        selectItemButton = (Button) findViewById(R.id.button_enter);
        selectItemButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data){
//        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
//            if(data.hasExtra(MyListActivity.CHOSEN_TEXT))
//                currentSelection.setText(data.getExtras().getString(MyListActivity.CHOSEN_TEXT));
//        }
//    }
}

