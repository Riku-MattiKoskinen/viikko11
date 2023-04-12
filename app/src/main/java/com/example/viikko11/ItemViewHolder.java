package com.example.viikko11;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ItemViewHolder extends RecyclerView.ViewHolder {
    public TextView itemText, itemNotes;
    public Button buttonModifyItem, buttonDeleteItem;
    public LinearLayout text_linear_layout, button_linear_layout;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        text_linear_layout = itemView.findViewById(R.id.text_linear_layout);
        button_linear_layout = itemView.findViewById(R.id.button_linear_layout);
        itemText = itemView.findViewById(R.id.itemName);
        itemNotes = itemView.findViewById(R.id.itemNotes);
        buttonDeleteItem = itemView.findViewById(R.id.itemDeleteButton);
        buttonModifyItem = itemView.findViewById(R.id.itemModifyButton);

        buttonModifyItem.setOnClickListener(v -> {
            int position = getAdapterPosition();
            Intent intent = new Intent(v.getContext(), AddItemActivity.class);
            intent.putExtra("isEditMode", true);
            intent.putExtra("itemPosition", position);
            v.getContext().startActivity(intent);
        });
    }



}
