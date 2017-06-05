package ca.centennialcollege.recycleviewproject.Adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import ca.centennialcollege.recycleviewproject.R;
import ca.centennialcollege.recycleviewproject.model.Datamodel;

/**
 * Created by Admin on 16-05-2017.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {


    private List<Datamodel> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            LinearLayout ll = (LinearLayout)view. findViewById(R.id.relative);
            TextView tv = new TextView(view.getContext());
           // tv.setText("Dynamic TextView" + i);
            tv.setId(R.id.textViewName);
            tv.setLayoutParams(
                    new RelativeLayout.LayoutParams(
                            RecyclerView.LayoutParams.WRAP_CONTENT,
                            RecyclerView.LayoutParams.MATCH_PARENT));
         //   tv.setla(5,10,20,5);
            tv.setTextColor(Color.BLACK);

            ll.addView(tv);


            TextView tv1 = new TextView(view.getContext());
            tv1.setLayoutParams(
                    new RelativeLayout.LayoutParams(
                            RecyclerView.LayoutParams.WRAP_CONTENT,
                            RecyclerView.LayoutParams.MATCH_PARENT));
            tv.setPadding(30,0,0,0);
            tv1.setId(R.id.textViewEmail);
            ll.addView(tv1);


            title = (TextView) view.findViewById(R.id.textViewName);
            genre = (TextView) view.findViewById(R.id.textViewEmail);

        }
    }
    public RecycleViewAdapter(List<Datamodel> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.catlayout, parent, false);


     ;
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Datamodel movie = moviesList.get(position);
        holder.title.setText(movie.getDisplayName());
        holder.genre.setText(movie.getCity());
    }




    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}
