package com.example.googlemapjsonparseretrofit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.googlemapjsonparseretrofit.R;
import com.example.googlemapjsonparseretrofit.model.LocationData;
import com.example.googlemapjsonparseretrofit.retrofit.Manager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String LOG = MainActivity.class.getName();

    TextView cadde,mahalle,ilce,il,ulke,posta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cadde = findViewById(R.id.cadde);
        mahalle = findViewById(R.id.mahalle);
        ilce = findViewById(R.id.ilce);
        il = findViewById(R.id.il);
        ulke = findViewById(R.id.ulke);
        posta = findViewById(R.id.posta);

        // https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyCYl7PTSqb8WhBgy49bp_l-3TNF9Koopk8&latlng=40.9927242,29.0231916
        getir();

    }

    public void getir() {
        Log.i(LOG,"getir is working");
        Call<LocationData> req = Manager.getInstance().getCity("40.9927242,29.0231916");
        req.enqueue(new Callback<LocationData>() {
            @Override
            public void onResponse(Call<LocationData> call, Response<LocationData> response) {
                if(response.isSuccessful()) {
                    Log.i(LOG,"response.isSuccessful() is working");
                    Log.i(LOG,"response : " + response);
                    LocationData location = response.body();
                    Log.i(LOG,"Location : " + location.getResults());
                    String caddeText = location.getResults().get(0).getAddressComponents().get(0).getLongName();
                    String mahalleText = location.getResults().get(0).getAddressComponents().get(1).getLongName();
                    String ilceText = location.getResults().get(0).getAddressComponents().get(2).getLongName();
                    String ilText = location.getResults().get(0).getAddressComponents().get(3).getLongName();
                    String ulkeText = location.getResults().get(0).getAddressComponents().get(4).getLongName();
                    String postaText = location.getResults().get(0).getAddressComponents().get(5).getLongName();

                    cadde.setText(caddeText);
                    mahalle.setText(mahalleText);
                    ilce.setText(ilceText);
                    il.setText(ilText);
                    ulke.setText(ulkeText);
                    posta.setText(postaText);

                }else{
                    Log.i(LOG,"response.isSuccessful() is not working");
                }

            }

            @Override
            public void onFailure(Call<LocationData> call, Throwable t) {
                Log.i(LOG,"onFailure | Throwable : "+t.toString());
            }
        });
    }
}
