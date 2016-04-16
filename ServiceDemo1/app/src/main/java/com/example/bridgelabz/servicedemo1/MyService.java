package com.example.bridgelabz.servicedemo1;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by bridgelabz on 23/12/15.
 */
public class MyService extends Service {
    private final IBinder mbinder = new LocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return mbinder;
    }

    public class LocalBinder extends Binder
    {
        public MyService getService()
        {
            return  MyService.this;
        }
    }

    public int factorial(int num)
    {
        int fact = 1;
        for(int i = num; i>=1 ; i++ )
        {
             fact = fact*i;
        }
        return fact;
    }
}
