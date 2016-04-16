package com.example.bridgelabz.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by bridgelabz on 26/12/15.
 */
public class MyReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Intent Recieved",Toast.LENGTH_SHORT).show();
    }
}
