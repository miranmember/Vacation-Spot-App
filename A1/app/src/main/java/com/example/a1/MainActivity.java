package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private BroadcastReceiver mReceiver2;
    private IntentFilter mFilter;

    private static final String TRAVEL_PERMISSION = "edu.uic.cs478.s21.travel";

    private static final String TOAST_INTENT = "edu.uic.cs478.BroadcastReceiver3.showToast";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermissionAndBroadcast();
            }
        });
    }

    private void checkPermissionAndBroadcast() {
        if (ActivityCompat.checkSelfPermission(this, TRAVEL_PERMISSION)
                == PackageManager.PERMISSION_GRANTED) {
            Intent aIntent = new Intent(this, secondActivity.class) ;
            startActivity(aIntent);
        }
        else {
            ActivityCompat.requestPermissions(this, new String[]{TRAVEL_PERMISSION}, 0);
        }

    }

    public void onRequestPermissionsResult(int code, String[] permissions, int[] results) {
        super.onRequestPermissionsResult(code, permissions, results);
        if (results.length > 0) {
            if (results[0] == PackageManager.PERMISSION_GRANTED) {
                Intent aIntent = new Intent(this, secondActivity.class) ;
                startActivity(aIntent);
            } else {
                Toast.makeText(this, "Bummer: No permission", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    protected void onResume() {
        super.onResume();

        mFilter = new IntentFilter(TOAST_INTENT);
        mFilter.setPriority(99);
        mReceiver2 = new MyReceiver2();
        registerReceiver(mReceiver2, mFilter);
    }

    protected void onPuase() {
        super.onPause();
        unregisterReceiver(mReceiver2);
    }
}