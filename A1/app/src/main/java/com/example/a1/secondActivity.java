package com.example.a1;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class secondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent aIntent = new Intent(Intent.ACTION_VIEW) ;
        aIntent.setComponent(new ComponentName( "com.example.a2","com.example.a2.MainActivity"));
        startActivity(aIntent);
    }
}
