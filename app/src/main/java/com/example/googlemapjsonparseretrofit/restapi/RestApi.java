package com.example.googlemapjsonparseretrofit.restapi;

import com.example.googlemapjsonparseretrofit.model.LocationData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {

    @GET("/maps/api/geocode/json")
    Call<LocationData> getInformation(@Query("latlng") String lat);

}
