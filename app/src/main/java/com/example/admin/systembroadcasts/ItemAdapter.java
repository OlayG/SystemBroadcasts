package com.example.admin.systembroadcasts;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 8/15/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    List<ItemToSell> itemToSells = new ArrayList<>();
    ItemToSell item;

    public ItemAdapter(List<ItemToSell> itemToSells) {
        this.itemToSells = itemToSells;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ItemToSell itemToSell = itemToSells.get(position);
        item = itemToSell;
        holder.tvItemName.setText("" + itemToSell.getItemName());
        holder.tvItemPrice.setText("" + itemToSell.getItemPrice());
        holder.ivItemPhoto.setImageResource(itemToSell.getItemImage());

    }

    @Override
    public int getItemCount() {
        return itemToSells.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivItemPhoto;
        TextView tvItemName, tvItemPrice;

        public ViewHolder(final View itemView) {
            super(itemView);

            final AlarmManager manager = (AlarmManager) itemView.getContext().getSystemService(Context.ALARM_SERVICE);

            ivItemPhoto = (ImageView) itemView.findViewById(R.id.ivItemPhoto);
            tvItemName = (TextView) itemView.findViewById(R.id.tvItemName);
            tvItemPrice = (TextView) itemView.findViewById(R.id.tvItemPrice);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), AlarmNotificationReceiver.class);
                    intent.putExtra("item", item);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(v.getContext(), 0, intent, 0);
                    manager.set(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime()+3000, pendingIntent);

                }
            });
        }
    }
}
