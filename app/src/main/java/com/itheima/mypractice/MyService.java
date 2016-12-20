package com.itheima.mypractice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {

        return new IMyAidlInterface.Stub() {

            @Override
            public void show() throws RemoteException {
                Log.d("tag", "test");
            }
        };
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
