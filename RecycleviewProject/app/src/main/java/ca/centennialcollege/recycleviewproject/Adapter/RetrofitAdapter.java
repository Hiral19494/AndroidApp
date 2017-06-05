package ca.centennialcollege.recycleviewproject.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import ca.centennialcollege.recycleviewproject.R;
import ca.centennialcollege.recycleviewproject.model.Datamodel;
import ca.centennialcollege.recycleviewproject.model.Movie;

/**
 * Created by Admin on 17-05-2017.
 */

public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private String movie;
    private int rowLayout;
    private Context context;



    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView name;
        TextView description;
        TextView movieDescription;
        TextView rating;
        ImageView img;


        public MovieViewHolder(View v) {
            super(v);

            RelativeLayout ll = (RelativeLayout) v. findViewById(R.id.movies_layout);


            ImageView i1 = new ImageView(v.getContext());
            i1.setId(R.id.imagview);
            RecyclerView.LayoutParams layoutparams = new RecyclerView.LayoutParams(200,200);

            i1.setLayoutParams(layoutparams);
//            i1.setPadding(0,0,70,0);

            ll.addView(i1);


            TextView tv = new TextView(v.getContext());
            // tv.setText("Dynamic TextView" + i);
            tv.setId(R.id.textViewName);
            RecyclerView.LayoutParams layoutparams1 = new RecyclerView.LayoutParams(1000,0);

            tv.setLayoutParams(layoutparams1);
          //  RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
           // params2.addRule(RelativeLayout.RIGHT_OF,i1.getId());
           layoutparams.setMargins(300,0,0,0);
            tv.setLayoutParams(layoutparams);
            tv.setTextColor(Color.BLACK);

            ll.addView(tv);



            RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);


            TextView tv1 = new TextView(v.getContext());

            params3.addRule(RelativeLayout.BELOW, tv.getId());

            //  tv.layout();
            tv1.setGravity(Gravity.CENTER_VERTICAL);
          //  layoutparams.setMargins(400,100,0,0);
           // tv1.setLayoutParams(layoutparams);
            tv1.setId(R.id.textViewDes);
            ll.addView(tv1,params3);


            name = (TextView) v.findViewById(R.id.textViewName);
            description =(TextView)v.findViewById(R.id.textViewDes);
            img =(ImageView) v.findViewById(R.id.imagview);

        }
    }

    public RetrofitAdapter(List<Movie> movies , int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public RetrofitAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {

        holder.name.setText(movies.get(position).getName());

        holder.description.setText(movies.get(position).getDescription());

        Picasso.with(context).load(movies.get(position).getImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.img);



    }



    @Override
    public int getItemCount() {
        return movies.size();
    }
}
