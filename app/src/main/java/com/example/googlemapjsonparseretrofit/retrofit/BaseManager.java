package com.example.googlemapjsonparseretrofit.retrofit;


import com.example.googlemapjsonparseretrofit.restapi.RestApi;

public class BaseManager {

    protected RestApi getRestApi() {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.URL);
        return restApiClient.getRestApi();
    }

}
