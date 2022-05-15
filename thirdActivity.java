package com.example.carparksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class thirdActivity extends AppCompatActivity {

    private TextView textView12;
    private TextView textView13;
    private TextView vehicles;
    private TextView vehicleh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ArrayList<String> vehicle1 = new ArrayList<String>();
        ArrayList<String> vehicle2 = new ArrayList<String>();

        Button stand = findViewById(R.id.stand);
        Button handi = findViewById(R.id.handi);
        Button menu = findViewById(R.id.menu);

        vehicles =findViewById(R.id.vehicles);
        vehicleh =findViewById(R.id.vehicleh);

        textView12 =  findViewById(R.id.textView12);
        textView13 = findViewById(R.id.textView13);

        textView12.setText("");
        textView13.setText("");

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thirdActivity.this,secondActivity.class);
                startActivity(intent);
            }
        });

        stand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vehicle1.size()<=14){
                    vehicle1.add(String.valueOf(vehicles.getText()));
                    int k=(15-vehicle1.size());
                    textView12.setText(String.valueOf(k));
                    Toast.makeText(thirdActivity.this,"Park your vehicle",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(thirdActivity.this,"No parking spaces available",Toast.LENGTH_SHORT).show();
                }
            }
        });

        handi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vehicle2.size()<=9){
                    vehicle2.add(String.valueOf(vehicleh.getText()));
                    int i=(10-vehicle2.size());
                    Toast.makeText(thirdActivity.this,"Park your vehicle",Toast.LENGTH_SHORT).show();
                    textView13.setText(String.valueOf(i));
                }
                else{
                    Toast.makeText(thirdActivity.this,"No parking spaces available",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}