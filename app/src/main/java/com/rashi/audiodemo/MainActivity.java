package com.rashi.audiodemo;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn;
    CountDownTimer start1;
    MyIntentService myIntentService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.button){
            record();
        }

    }

    void record(){

        Intent intent = new Intent(this,MyIntentService.class);
        this.startService(intent);
       start1 = new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                moveTaskToBack(true);
            }
        }.start();


    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}
