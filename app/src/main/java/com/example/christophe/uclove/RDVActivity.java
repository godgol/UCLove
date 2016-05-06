package com.example.christophe.uclove;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class RDVActivity extends AppCompatActivity{
    public Button validate;
    public DatePicker date;
    public Button okDate;
    public TimePicker time;
    public Button okTime;
    public Button placeOk;
    public EditText place;
  //  public GoogleMap map;
  //  public MyLocationOverlay myLoc;
    public String login = CurrentUser.current_user;
    private boolean dateChecked = false;
    private boolean timeChecked = false;
    private boolean placeChecked = false;
    private String day;
    private String month;
    private String year;
    private String hour;
    private String minute;
    private String loc;
    String friend;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_rdv);

        // recuperation des vues
        validate = (Button)findViewById(R.id.validate);
        date = (DatePicker) findViewById(R.id.date);
        okDate = (Button)findViewById(R.id.okDate);
        time = (TimePicker) findViewById(R.id.time);
        okTime = (Button) findViewById(R.id.okTime);
        placeOk = (Button) findViewById(R.id.placeOk);
        place = (EditText)findViewById(R.id.place);

        okDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                int d = date.getDayOfMonth();
                day = Integer.toString(d);
                int m = date.getMonth();
                month = Integer.toString(m);
                int y = date.getYear();
                year = Integer.toString(y);
                dateChecked = true;
            }
        });

        okTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                int h = time.getHour();
                hour = Integer.toString(h);
                int m = time.getMinute();
                minute = Integer.toString(m);
                timeChecked = true;
            }
        });

        placeOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                loc = place.getText().toString();
                placeChecked = true;
            }
        });

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(dateChecked==true && timeChecked==true && placeChecked==true){ // si l'utilisateur a fourni toutes les infos necessaires
                    friend = extras.getString("friend");
                    RDV rdv = new RDV();
                    rdv.setSender(login);
                    rdv.setReceiver(friend);
                    rdv.setDate(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                    rdv.setEtat("true");
                    rdv.setLocation(loc);
                    DataBaseHandler2 db = new DataBaseHandler2(RDVActivity.this);
                    db.createRDV(rdv);
                    db.closeDB();
                }
                else // s'il manque des infos
                    Toast.makeText(RDVActivity.this, "Please complete all informations.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}