import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
public class ProfileActivity extends Activity {
    private RadioGroup groupGender = null;
    private EditText age;
    private RadioGroup groupHairs = null;
    private RadioGroup groupEyes = null;
    private EditText location = null;
    private RadioGroup groupInclination = null;
    private Button gallery = null;
    private Button ageOk = null;
    private Button locationOk = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        location = (EditText)findViewById(R.id.location);
        groupGender = (RadioGroup) findViewById(R.id.groupGender);
        groupHairs = (RadioGroup) findViewById(R.id.groupHairs);
        groupEyes = (RadioGroup) findViewById(R.id.groupEyes);
        groupInclination = (RadioGroup) findViewById(R.id.groupInclination);
        age = (EditText)findViewById(R.id.age);
        gallery = (Button)findViewById(R.id.gallery);
        ageOk = (Button)findViewById(R.id.ageOk);
        locationOk = (Button)findViewById(R.id.locationOk)

        groupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch(checkedId)
                {
                    case R.id.male:
                        break;
                    case R.id.female:
                        break;
                }
            }
        });
        groupHairs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch(checkedId)
                {
                    case R.id.brownHairs:
                        break;
                    case R.id.blackHairs:
                        break;
                    case R.id.blondHairs:
                        break;
                    case R.id.redHairs:
                        break;
                    case R.id.bald:
                        break;
                }
            }
        });
        groupEyes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch(checkedId)
                {
                    case R.id.brownEyes:
                        break;
                    case R.id.blueEyes:
                        break;
                    case R.id.greenEyes:
                        break;
                }
            }
        });
        groupInclination.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch(checkedId)
                {
                    case R.id.hetero:
                        break;
                    case R.id.homo:
                        break;
                    case R.id.bi:
                        break;
                }
            }
        });
        locationOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String loc = location.getText().toString();
            }
        });
        ageOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String str = location.getText().toString();
                int userAge = Integer.parseInt(str);
            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(ProfileActivity.this, GalleryActivity.class);
                startActivity(i);
            }
        });

    }
}