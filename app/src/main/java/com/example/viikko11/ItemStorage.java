package com.example.viikko11;
import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.lang.ClassNotFoundException;

public class ItemStorage {
    private ArrayList<ShoppingItem> items = new ArrayList<>();
    private static ItemStorage storage = null;

    private ItemStorage() {
    }

    public static ItemStorage getInstance() {
        if (storage == null) {
            storage = new ItemStorage();
        }
        return storage;
    }

    public ArrayList<ShoppingItem> getItems() {
        return items;
    }
    public void addItem(ShoppingItem item) {
        items.add(item);
    }

    public void saveItems(Context context) {
        try {
            ObjectOutputStream itemWriter = new ObjectOutputStream(context.openFileOutput("items.data", Context.MODE_PRIVATE));
            itemWriter.writeObject(items);
            itemWriter.close();
        } catch (IOException e) {
            System.out.println("Items saving failed");
        }
    }

    public void loadItems(Context context) {
        try {
            ObjectInputStream itemReader = new ObjectInputStream(context.openFileInput("items.data"));
            items = (ArrayList<ShoppingItem>) itemReader.readObject();
            itemReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Items file not found. It will be created when new items are added.");
        } catch (IOException e) {
            System.out.println("Items reading failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Items reading failed");
            e.printStackTrace();
        }
    }


}
