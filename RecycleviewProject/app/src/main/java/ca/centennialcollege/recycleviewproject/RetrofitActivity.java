package ca.centennialcollege.recycleviewproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ca.centennialcollege.recycleviewproject.Adapter.RecycleViewAdapter;
import ca.centennialcollege.recycleviewproject.Adapter.RecyclerItemClickListener;
import ca.centennialcollege.recycleviewproject.Adapter.RetrofitAdapter;
import ca.centennialcollege.recycleviewproject.model.DataResponse;
import ca.centennialcollege.recycleviewproject.model.Datamodel;
import ca.centennialcollege.recycleviewproject.model.Movie;
import ca.centennialcollege.recycleviewproject.rest.ApiClient;
import ca.centennialcollege.recycleviewproject.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 17-05-2017.
 */

public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private List<Movie> movies = new ArrayList<>();
    RecyclerView recyclerView;

    // TODO - insert your themoviedb.org API KEY here
    //  private final static String API_KEY = "5902463023c6c5790885e78d";
    // private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

RelativeLayout layout = new RelativeLayout(this);
        layout.setId(R.id.activity_main1);
        setContentView(layout);

        RecyclerView recycle = new RecyclerView(getApplicationContext());
        recycle.setId(R.id.recycler_view);
        layout.addView(recycle);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click

                        Intent i = new Intent(getApplicationContext(), MovieDetails.class);

                        i.putExtra("name", movies.get(position).getName());
                        i.putExtra("des", movies.get(position).getDescription());
                            i.putExtra("dob",movies.get(position).getDob());
                        i.putExtra("country",movies.get(position).getCountry());
                        i.putExtra("image", movies.get(position).getImage());


                        startActivity(i);


                    }
                })
        );

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);


        Call<DataResponse> call = apiService.getTopDetails();

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                int statusCode = response.code();
                Log.d("hi","123");
                 movies = response.body().getActors();
                Log.d("hii","hii");

                recyclerView.setAdapter(new RetrofitAdapter(movies,R.layout.list_item_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}

