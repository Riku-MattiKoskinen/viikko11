package com.example.viikko11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viikko11.R;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private List<ShoppingItem> shoppingItems;
    private Context context;
    private OnItemDeleteListener onItemDeleteListener;

    public ShoppingListAdapter(Context context, List<ShoppingItem> shoppingItems, OnItemDeleteListener onItemDeleteListener) {
        this.shoppingItems = shoppingItems;
        this.context = context;
        this.onItemDeleteListener = onItemDeleteListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ShoppingItem item = shoppingItems.get(position);
        holder.itemText.setText(item.getName());
        holder.itemNotes.setText(item.getNotes());

        holder.buttonDeleteItem.setOnClickListener(v -> {
            if (onItemDeleteListener != null) {
                onItemDeleteListener.onItemDelete(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return shoppingItems.size();
    }

    public void updateItems(List<ShoppingItem> newItems) {
        shoppingItems.clear();
        shoppingItems.addAll(newItems);
    }

    public interface OnItemDeleteListener {
        void onItemDelete(int position);
    }
}