package ca.centennialcollege.recycleviewproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Admin on 21-05-2017.
 */

public class MovieDetails extends AppCompatActivity {


    TextView  Name, Des,dob,co;
    int height = 50;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.movie_activity);

        RelativeLayout l2 = new RelativeLayout(this);
        l2.setId(R.id.movie);
        setContentView(l2);


      //  RelativeLayout ll = (RelativeLayout) findViewById(R.id.movie);


        ImageView i1 = new ImageView(this);
        i1.setId(R.id.editimage);
        RecyclerView.LayoutParams layoutparams = new RecyclerView.LayoutParams(200,200);

        i1.setLayoutParams(layoutparams);
//            i1.setPadding(0,0,70,0);

        l2.addView(i1);


        TextView tv = new TextView(this);
        // tv.setText("Dynamic TextView" + i);
        tv.setId(R.id.EdittextViewName);
        RecyclerView.LayoutParams layoutparams1 = new RecyclerView.LayoutParams(1000,0);

        tv.setLayoutParams(layoutparams1);
        //  RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        // params2.addRule(RelativeLayout.RIGHT_OF,i1.getId());
        layoutparams.setMargins(300,0,0,0);
        tv.setLayoutParams(layoutparams);
        tv.setTextColor(Color.BLACK);

        l2.addView(tv);



        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);


        TextView tv1 = new TextView(this);

        params3.addRule(RelativeLayout.BELOW, tv.getId());

        //  tv.layout();
        tv1.setGravity(Gravity.CENTER_VERTICAL);
        layoutparams.setMargins(400,300,0,400);
        tv1.setLayoutParams(layoutparams);
        tv1.setId(R.id.EdittextViewDes);
        l2.addView(tv1,params3);



        RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);


        TextView tv2 = new TextView(this);

        params3.addRule(RelativeLayout.BELOW, i1.getId());

        //  tv.layout();
        tv2.setGravity(Gravity.CENTER_VERTICAL);
        layoutparams.setMargins(0,100,0,0);
        tv2.setLayoutParams(layoutparams);
        tv2.setPadding(0,450,0,0);
        tv2.setId(R.id.dob);
        l2.addView(tv2,params4);


        Name = (TextView) findViewById(R.id.EdittextViewName);
        Des = (TextView) findViewById(R.id.EdittextViewDes);
         img = (ImageView) findViewById(R.id.editimage);
        dob = (TextView)findViewById(R.id.dob);
      //  co= (TextView)findViewById(R.id.cou);


        Bundle extras = getIntent().getExtras();

        Name.setText(extras.getString("name"));
        dob.setText(extras.getString("dob"));
        //co.setText(extras.getString("country"));
        Des.setText(extras.getString("des"));
        Picasso.with(this).load(extras.getString("image")).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(img);
    }
}



