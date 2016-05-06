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
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class RDVActivity extends AppCompatActivity{
    //Initialiser les variables
    Bundle extras = getIntent().getExtras();
    public Button validate;
    public DatePicker date;
    public Button okDate;
    public EditText time;
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
    private String t;
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
        time = (EditText) findViewById(R.id.time);
        okTime = (Button) findViewById(R.id.okTime);
        placeOk = (Button) findViewById(R.id.placeOk);
        place = (EditText)findViewById(R.id.place);

        //Boutton accepter la Date
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

        //Boutton accepter l'heure
        okTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                t = time.getText().toString();
                timeChecked = true;
            }
        });

        //Boutton accepter le lieu
        placeOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                loc = place.getText().toString();
                placeChecked = true;
            }
        });

        //Boutton valider
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(dateChecked && timeChecked && placeChecked){ // si l'utilisateur a fourni toutes les infos necessaires
                    Bundle extras = getIntent().getExtras();
                    friend = extras.getString("friend");
                    RDV rdv = new RDV();
                    rdv.setSender(login);
                    rdv.setReceiver(friend);
                    rdv.setDate(year + "-" + month + "-" + day + " " + t);
                    rdv.setEtat("true");
                    rdv.setLocation(loc);
                    DatabaseHandler2 db = new DatabaseHandler2(RDVActivity.this);
                    db.createRDV(rdv);
                    db.closeDB();
                }
                else // s'il manque des infos
                    Toast.makeText(RDVActivity.this, "Please complete all informations.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}