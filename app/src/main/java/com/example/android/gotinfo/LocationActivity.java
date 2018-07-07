package com.example.android.gotinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.gotinfo.Api.ApiClient;
import com.example.android.gotinfo.Api.ApiInterface;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationActivity extends AppCompatActivity {

    TextView listLocation;
    private ApiInterface apiInterface;
    String name;
    List<Datum> datum;
    List<String> locations;
    String locationString = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        Intent myintent = getIntent();
        name = myintent.getStringExtra("name");

        listLocation = findViewById(R.id.list_location);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<LocationResponse> call = apiInterface.getLocations(name);
        call.enqueue(new Callback<LocationResponse>() {
            @Override
            public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {
                  datum = response.body().getData();
                 locations =  datum.get(0).getLocations();

                 for (int i=0;i<locations.size();i++){
                     locationString = locations.get(i) + "\n\n";
                 }

            }

            @Override
            public void onFailure(Call<LocationResponse> call, Throwable t) {

            }
        });

    }
}
