package com.example.admin.systembroadcasts;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    DynamicReceiver myDynamicReceiver;
    @BindView(R.id.rvItemList)
    RecyclerView rvItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Intent intent = new Intent(this, ListIntentService.class);
        intent.putExtra("listSize", 100);
        intent.setAction("RecycleList");
        startService(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();

        myDynamicReceiver = new DynamicReceiver(rvItemList);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("populateList");
        registerReceiver(myDynamicReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        unregisterReceiver(myDynamicReceiver);
        super.onStop();
    }
}
