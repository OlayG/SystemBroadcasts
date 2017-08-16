package com.example.admin.systembroadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import java.util.List;

/**
 * Created by Admin on 8/15/2017.
 */

public class DynamicReceiver extends BroadcastReceiver {

    RecyclerView rvItemList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    ItemAdapter itemAdapter;
    List<ItemToSell> itemToSells;

    public DynamicReceiver(RecyclerView rvItemList) {
        this.rvItemList = rvItemList;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()){

            case "populateList":
                Toast.makeText(context, "doSomething", Toast.LENGTH_SHORT).show();
                layoutManager = new LinearLayoutManager(context);
                itemAnimator = new DefaultItemAnimator();
                rvItemList.setLayoutManager(new GridLayoutManager(context, 2));
                rvItemList.setItemAnimator(itemAnimator);


                itemToSells = intent.getParcelableArrayListExtra("itemList");
                itemAdapter = new ItemAdapter(itemToSells);
                rvItemList.setAdapter(itemAdapter);
                itemAdapter.notifyDataSetChanged();

                break;
        }
    }
}
