package com.example.a3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements TitleFragment.ListSelectionListener{
    static String[] mTitleArray;
    static String[] mWebArray;
    static ArrayList<Integer> img = new ArrayList<Integer>(
            Arrays.asList(R.drawable.img1, R.drawable.img2, R.drawable.img3,
                    R.drawable.img4, R.drawable.img5));
    private ImgFragment mDetailsFragment;

    private static final String TravelPermission = "edu.uic.cs478.s21.travel" ;
    private static final String TOAST_INTENT = "edu.uic.cs478.BroadcastReceiver3.showToast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.ic_baseline_card_travel_24);
        mTitleArray = getResources().getStringArray(R.array.Titles);
        setContentView(R.layout.activity_main);
        mDetailsFragment = (ImgFragment) getSupportFragmentManager().findFragmentById(R.id.details);
        mWebArray = getResources().getStringArray(R.array.Web);
    }

    @Override
    public void onListSelection(int index) {
        if (mDetailsFragment.getShownIndex() != index) {
            mDetailsFragment.showQuoteAtIndex(index);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        menu.getItem(0).setOnMenuItemClickListener(onMenu);
        menu.getItem(1).setOnMenuItemClickListener(onMenu);
        return true;
    }

    private final MenuItem.OnMenuItemClickListener onMenu = new MenuItem.OnMenuItemClickListener(){
        @Override
        public boolean onMenuItemClick(MenuItem item){
            if (item.getTitle().toString().equals("Exit")) {
                finish();
            } else {
                if (mDetailsFragment.getShownIndex() != -1) {
                    Intent aIntent = new Intent(TOAST_INTENT);
                    aIntent.putExtra("index", Integer.toString(mDetailsFragment.getShownIndex()));
                    aIntent.putExtra("web", mWebArray[mDetailsFragment.getShownIndex()]);
                    sendOrderedBroadcast(aIntent, TravelPermission);
                } else {
                    Toast.makeText(getApplicationContext(), "Please select an Option", Toast.LENGTH_SHORT).show() ;
                }
            }
            return true;
        }
    };
}