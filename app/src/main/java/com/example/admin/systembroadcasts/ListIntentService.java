package com.example.admin.systembroadcasts;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by Admin on 8/15/2017.
 */

public class ListIntentService extends IntentService {
    public ArrayList<ItemToSell> itemToSell;

    public ListIntentService() {
        super("ListIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int num = intent.getIntExtra("listSize", 10);
        createRandomItems(num);


        Intent i = new Intent();
        i.setAction("populateList");
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("itemList", itemToSell);
        i.putExtras(bundle);
        sendBroadcast(i);

    }

    private void createRandomItems(int num) {

        itemToSell = new ArrayList<>();

        for (int i = 0; i < num; i++) {

            itemToSell.add(new ItemToSell(R.drawable.iphone, "IPhone 8", null, 800));

        }



    }
}
