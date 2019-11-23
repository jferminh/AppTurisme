package com.example.apprecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import static androidx.core.content.ContextCompat.startActivity;

public class mainOnClickListener implements View.OnClickListener {
    private final Context context;
    RecyclerView recyclerView;
    public static int currentItem;

    public mainOnClickListener(Context context) {
        this.context = context;
    }


    @Override
    public void onClick(View v) {
        recyclerView = recyclerView.findViewById(R.id.myRecycler);
        currentItem = recyclerView.getChildAdapterPosition(v);
        startActivity(new Intent(getApplicationContext(), DetailActivity.class));
//        startActivity(new Intent(getApplicationContext(), DetailActivity.class));

    }
}
