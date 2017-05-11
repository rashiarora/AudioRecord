package com.rashi.audiodemo;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.rashi.audiodemo.action.FOO";
    private static final String ACTION_BAZ = "com.rashi.audiodemo.action.BAZ";
    MediaRecorder recorder;
    Handler handler;
    MyIntentService myIntentService;

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.rashi.audiodemo.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.rashi.audiodemo.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.OutputFormat.DEFAULT);
        String storageDir = Environment.getExternalStorageDirectory()+File.separator+"Sound";
        //if(!storageDir.exists()){
          //  storageDir.mkdirs();
        //}
        File folder = new File(storageDir);
        if(!folder.exists()){
        folder.mkdirs();}
        Date date = new Date();
        File file = new File(storageDir+"/"+date.getDate() +"Audio1.mp3");
        recorder.setOutputFile(file.getAbsolutePath());
        try {
            recorder.prepare();
            recorder.start();

            //Toast.makeText(this,"Started",Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    recorder.stop();
                    recorder.release();
                }
            },7000000);
        }catch (IllegalStateException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);
        super.onStartCommand(intent, flags, startId);


        return START_STICKY;

    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public void stopRecording(){
        try {
            if(recorder!= null){
                recorder.stop();
                recorder.release();
                recorder = null;
                Toast.makeText(this,"Stopped",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */

    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
