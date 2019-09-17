package com.example.googlemapjsonparseretrofit.retrofit;

import com.example.googlemapjsonparseretrofit.model.LocationData;

import retrofit2.Call;

public class Manager extends BaseManager {


    private static Manager ourInstance = new Manager();

    public static synchronized Manager getInstance() {
        return ourInstance;
    }

    public Call<LocationData> getCity(String lat) {
        Call<LocationData> x = getRestApi().getInformation(lat);
        return x;
    }

}
