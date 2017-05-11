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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SensorEventListener{

    Button btn;
    CountDownTimer start1;
    MyIntentService myIntentService;
    SensorManager sensorManager;
    Sensor sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
         sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.button){
            //record();
            //sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        }

    }

    void record(){

        //Intent intent = new Intent(this,MyIntentService.class);
        //this.startService(intent);
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

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float[] values = event.values;

            float x = values[0];
            float y = values[1];
            float z = values[2];

            // set the data on textView
            float calculation = ((x * x) + (y * y) + (z * z)) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
            if (calculation > 3) {
                Intent i = new Intent("SHAKE");// Implicit Intent
                sendBroadcast(i);
                start1 = new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {

                        moveTaskToBack(true);
                    }
                }.start();

                Toast.makeText(this, "Phone Shake Detected", Toast.LENGTH_LONG).show();
                sensorManager.unregisterListener(this);

            }
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
