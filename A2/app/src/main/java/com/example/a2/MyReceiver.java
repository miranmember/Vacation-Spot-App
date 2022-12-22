package com.example.a2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Toast.makeText(arg0, "Launching web for vacation spot " + arg1.getExtras().getString("index"), Toast.LENGTH_SHORT).show() ;

    }
}
