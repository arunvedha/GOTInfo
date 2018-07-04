package com.example.android.gotinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.gotinfo.Api.ApiClient;
import com.example.android.gotinfo.Api.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchNameActivity extends AppCompatActivity {

    private String TAG = "searchActivity";
    private ApiInterface apiInterface;
    private static final int FLAG = 1;
    TextView nameTextView;
    Button charInfo;
    String titles = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_name);
        final Intent intent = getIntent();
        final String query = intent.getStringExtra("String");
        nameTextView = findViewById(R.id.character_name);
        charInfo = findViewById(R.id.char_info);
        charInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<NameResponse> call = apiInterface.getCharacter(query);
        call.enqueue(new Callback<NameResponse>() {
            @Override
            public void onResponse(Call<NameResponse> call, Response<NameResponse> response) {
                final Data data = response.body().getData();
                final String text = data.getName();
                final String spouse = data.getSpouse();
                final String house= data.getHouse();
                final int size = data.getTitles().size();
                final String[] titleArray = new String[size];

                for (int i=0;i<size;i++){
                     titleArray[i]=data.getTitles().get(i);
                     titles+= titleArray[i]+"\n";
                }
                Log.e(TAG,"to check if name was returned " + text);
                nameTextView.setText(text);
                charInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent myIntent = new Intent(SearchNameActivity.this, CharInfoActivity.class);
                        intent.putExtra("name",text);
                        intent.putExtra("house",house);
                        intent.putExtra("spouse",spouse);
                        intent.putExtra("titles",titles);
                        SearchNameActivity.this.startActivity(myIntent);
                    }
                });
            }

            @Override
            public void onFailure(Call<NameResponse> call, Throwable t) {

            }
        });


    }
}
