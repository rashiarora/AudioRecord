package com.rashi.audiodemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

    //CountDownTimer start1;
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("SHAKE")) {
            System.out.println("User is present");
            Log.i("msg","Shake detected by reciever");
            /*Intent s = new Intent(context, MyIntentService.class);
            //s.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startService(s);*/
            /*start1 = new CountDownTimer(5000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {


                }
            }.start();
*/
        } else {
            System.out.println("User is not present");
            Log.i("errormsg","Shake not detected by reciever");
        }
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        SensorManager sManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
//        sensor = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//        sManager.registerListener(new MainActivity(), sensor, SensorManager.SENSOR_DELAY_NORMAL);


    }
}
