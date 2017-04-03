package mody.sampleproject;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, SimpleService.class);
       // intent.setAction("someAction");
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i("SampleProject", "Service connected : " + service + " ");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i("SampleProject", "Service disconnected : " + name + " ");
            }
        }, BIND_AUTO_CREATE);
        startService(intent);
        Log.i("SampleProject", "Main , " +  android.os.Process.myPid() + " ; " + Thread.currentThread().getId());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);
                    Log.i("SampleProject", "Delay #1 completed , " +  android.os.Process.myPid());
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                    Log.i("SampleProject", "Delay #1 failed , " +  android.os.Process.myPid());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5000);
                    Log.i("SampleProject", "Delay #2 completed , " +  android.os.Process.myPid());
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                    Log.i("SampleProject", "Delay #2 failed , " +  android.os.Process.myPid());
                }
            }
        }).start();
        Executors.newCachedThreadPool();
       // finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("SampleProject", "Main destroy, " +  android.os.Process.myPid() + " ; " + Thread.currentThread().getId());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("SimpleService","CONFIG CHANGED");
    }

    interface some {

    }
}
