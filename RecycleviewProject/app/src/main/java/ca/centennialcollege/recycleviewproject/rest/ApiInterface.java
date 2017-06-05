package ca.centennialcollege.recycleviewproject.rest;

import ca.centennialcollege.recycleviewproject.model.DataResponse;
import ca.centennialcollege.recycleviewproject.model.Datamodel;

import ca.centennialcollege.recycleviewproject.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
@GET("jsonActors")
    Call<DataResponse> getTopDetails();
   // @GET("userInfo")
    //Call<DataResponse> getTopDetails();



}
