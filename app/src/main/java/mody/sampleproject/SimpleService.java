package mody.sampleproject;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.FileDescriptor;
import java.util.HashSet;

public class SimpleService extends Service{

   /* public SimpleService() {
        super("My name");
    }

    public SimpleService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("SimpleService","Service handle intent " + intent.getAction());
        try{
            Thread.sleep(7000);
            Log.i("SampleProject","Service done,  " + android.os.Process.myPid());
        }catch (InterruptedException ex){
            Log.i("SampleProject","Service failed,  " + android.os.Process.myPid());
        }
    }*/
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("SimpleService","Service created");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        Log.i("SimpleService","Service started :" + intent.getAction());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("SimpleService","Service is binded");
        return new IBinder() {
            @Override
            public String getInterfaceDescriptor() throws RemoteException {
                return null;
            }

            @Override
            public boolean pingBinder() {
                return false;
            }

            @Override
            public boolean isBinderAlive() {
                return false;
            }

            @Override
            public IInterface queryLocalInterface(String descriptor) {
                return null;
            }

            @Override
            public void dump(FileDescriptor fd, String[] args) throws RemoteException {

            }

            @Override
            public void dumpAsync(FileDescriptor fd, String[] args) throws RemoteException {

            }

            @Override
            public boolean transact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
                return false;
            }

            @Override
            public void linkToDeath(DeathRecipient recipient, int flags) throws RemoteException {

            }

            @Override
            public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
                return false;
            }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("SimpleService","Service start commmand : " + intent.getAction());
        /*new Thread(new Runnable() {
            @Override
            public void run() {*/
                try{
                    Thread.sleep(7000);
                    Log.i("SampleProject","Service done,  " + android.os.Process.myPid());
                }catch (InterruptedException ex){
                    Log.i("SampleProject","Service failed,  " + android.os.Process.myPid());
                }
            /*}
        }).start();*/
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("SimpleService","Service on destroy");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("SimpleService","Service on config changed");
    }

}
