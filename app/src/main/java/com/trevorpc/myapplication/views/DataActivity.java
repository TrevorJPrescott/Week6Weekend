package com.trevorpc.myapplication.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.trevorpc.myapplication.R;

public class DataActivity extends AppCompatActivity {

    FirebaseDatabase database;
    Button btnClockIn, btnClockOut, btnLogOut, btnEmail;
    TextView tvName,tvWeek,tvDay,tvLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        btnClockIn = findViewById(R.id.btnClockIn);
        btnClockOut = findViewById(R.id.btnClockOut);
        btnLogOut = findViewById(R.id.btnLogOut);
        btnEmail = findViewById(R.id.btnEmail);

        tvName = findViewById(R.id.tvName);
        tvWeek = findViewById(R.id.tvWeek);
        tvDay = findViewById(R.id.tvDay);
        tvLocation = findViewById(R.id.tvLocation);

        btnClockIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                finish();
            }
        });

        btnClockOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get timer
                // stop timer
                // get location
                // push
                finish();
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logout
                finish();
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get data
                // email
                finish();
            }
        });
    }
}
