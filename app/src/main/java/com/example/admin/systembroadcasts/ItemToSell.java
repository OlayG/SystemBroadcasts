package com.example.admin.systembroadcasts;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 8/15/2017.
 */

public class ItemToSell implements Parcelable{

    int itemImage;
    String itemName, itemDescription;
    int itemPrice;

    public ItemToSell(int itemImage, String itemName, String itemDescription, int itemPrice) {
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

    protected ItemToSell(Parcel in) {
        itemImage = in.readInt();
        itemName = in.readString();
        itemDescription = in.readString();
        itemPrice = in.readInt();
    }

    public static final Creator<ItemToSell> CREATOR = new Creator<ItemToSell>() {
        @Override
        public ItemToSell createFromParcel(Parcel in) {
            return new ItemToSell(in);
        }

        @Override
        public ItemToSell[] newArray(int size) {
            return new ItemToSell[size];
        }
    };

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(itemImage);
        dest.writeString(itemName);
        dest.writeString(itemDescription);
        dest.writeInt(itemPrice);
    }
}
