package com.example.viikko11;
import java.io.Serializable;

public class ShoppingItem implements Serializable {
    private static final long serialVersionUID = 1L;
    String itemName;
    String itemNotes;
    long timestamp;


    public ShoppingItem(String itemName, String itemNotes) {
        this.itemName = itemName;
        this.itemNotes = itemNotes;
        this.timestamp = System.currentTimeMillis();
    }

    public String getName() {
        return itemName;
    }

    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public String getNotes() {
        return itemNotes;
    }

    public void setNotes(String itemNotes) {
        this.itemNotes = itemNotes;
    }
    public long getTimeStamp() {
        return timestamp;
    }
}
