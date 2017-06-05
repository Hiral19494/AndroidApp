package ca.centennialcollege.recycleviewproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by Admin on 17-05-2017.
 */
public class DetailActivity extends AppCompatActivity {


    EditText Id, Name, Gender, date, height, signature, city, latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailactivity);

        Id = (EditText) findViewById(R.id.editText);
        Name = (EditText) findViewById(R.id.editText2);
    //    Gender = (EditText) findViewById(R.id.editText3);
     //   date = (EditText) findViewById(R.id.editText4);
       // height = (EditText) findViewById(R.id.editText5);
        //signature = (EditText) findViewById(R.id.editText6);
        city = (EditText) findViewById(R.id.editText7);
        //latitude = (EditText) findViewById(R.id.editText8);
        //longitude = (EditText) findViewById(R.id.editText9);


        Bundle extras = getIntent().getExtras();

        Id.setText(extras.getString("id"));
        Name.setText(extras.getString("name"));
//        if (extras.getString("gender").matches("1")){
//            Gender.setText("Male");
//        }
//        else {
//            Gender.setText("Female");
//        }
//
//        date.setText(extras.getString("date"));
//        height.setText(extras.getString("height"));
//        signature.setText(extras.getString("signature"));
        city.setText(extras.getString("city"));
//        latitude.setText(extras.getString("latitude"));
//        longitude.setText(extras.getString("longitude"));

    }
}


