package com.example.carparksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer ;
    private int i = 0;
    private ProgressBar progressBar;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        textView = findViewById(R.id.textView);
        textView.setText("");

        timer = new Timer();
        final long period = 100;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(i<100){
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run(){
                            textView.setText(String.valueOf(i) + "%");
                            progressBar.setProgress(i);
                        }
                    });
                    i++;
                }else{
                    timer.cancel();
                    Intent intent = new Intent(MainActivity.this,secondActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },0,period);
    }
}