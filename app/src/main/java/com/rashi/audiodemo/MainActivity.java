package com.rashi.audiodemo;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn;
    //CountDownTimer start1;
   /* MyIntentService myIntentService;
    SensorManager sensorManager;
    Sensor sensor;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
         /*sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
*/      record();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.button){
            Toast.makeText(this,"Button Clicked",Toast.LENGTH_LONG).show();
            //record();
            //sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        }

    }

    void record(){

        Intent intent = new Intent(this,MyIntentService.class);
        this.startService(intent);
       /*start1 = new CountDownTimer(5000,5000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                moveTaskToBack(true);
            }
        }.start();*/


    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }


}
