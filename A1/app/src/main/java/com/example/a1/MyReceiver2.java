package com.example.a1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context arg0, Intent arg1) {
        arg0.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(arg1.getExtras().getString("web"))));
    }
}
