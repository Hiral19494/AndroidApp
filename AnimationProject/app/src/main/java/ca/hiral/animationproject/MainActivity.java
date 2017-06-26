package ca.hiral.animationproject;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv1;
    AnimationDrawable Anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1 = (ImageView) findViewById(R.id.image);
        try {
            BitmapDrawable frame1 = (BitmapDrawable) getResources().getDrawable(
                    R.drawable.pic_s1_1);
            BitmapDrawable frame2 = (BitmapDrawable) getResources().getDrawable(
                    R.drawable.pic_s1_2);
            BitmapDrawable frame3 = (BitmapDrawable) getResources().getDrawable(
                    R.drawable.pic_s1_3);

            Anim = new AnimationDrawable();
            Anim.addFrame(frame1, 200);
            Anim.addFrame(frame2, 200);
            Anim.addFrame(frame3, 200);
            Anim.setOneShot(false);
            iv1.setBackgroundDrawable(Anim);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                public void run() {

                    Anim.start();

                }
            }, 5000);

        } catch (Exception e) {
            // TODO: handle exception
        }



    }
}
