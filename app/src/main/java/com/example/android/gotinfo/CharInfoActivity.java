package com.example.android.gotinfo;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CharInfoActivity extends AppCompatActivity {
    TextView nameInfo;
    TextView titleInfo;
    TextView houseInfo;
    TextView spouseInfo;
    String TAG = "CharInfoActivity";
    String names;
    String title;
    String house;
    String spouse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_info);
        Bundle info = getIntent().getExtras();
        names = info.getString("name");
        title = info.getString("titles");
        house = info.getString("house");
        spouse = info.getString("spouse");
        Log.e(TAG,"check if name was returned " + names);

        nameInfo.setText(names);
        titleInfo.setText(title);
        houseInfo.setText(house);
        spouseInfo.setText(spouse);

    }
}
