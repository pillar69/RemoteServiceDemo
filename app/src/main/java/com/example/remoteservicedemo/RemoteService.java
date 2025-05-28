package com.example.remoteservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;

public class RemoteService extends Service {
    private static final String TAG = "RemoteService";
    
    private final IRemoteService.Stub binder = new IRemoteService.Stub() {
        public int getPid() {
            Log.d(TAG, "getPid: ");
            return Process.myPid();
        }

        public void basicTypes(int anInt, long aLong, boolean aBoolean,
                               float aFloat, double aDouble, String aString) {
            // Does nothing.
        }
    };

    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return binder;
    }
}