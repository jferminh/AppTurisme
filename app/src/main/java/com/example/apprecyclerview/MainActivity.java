package com.example.apprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MainData> data;
    public RecyclerView recyclerView;
    public static View.OnClickListener mainOnClickListener;
    public static int currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<>();
        recyclerView = findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
        llenarData();
        RecyclerView.Adapter adapter = new MainAdapter(data);
        recyclerView.setAdapter(adapter);
        mainOnClickListener = new MainOnClickListener(this);
        recyclerView.setOnClickListener(mainOnClickListener);
//        startActivity(new Intent(getApplicationContext(), DetailActivity.class));
    }

    private void llenarData() {
        for (int i = 0; i < MainDataset.nameArray.length; i++){

            data.add(new MainData(
                    MainDataset.imageArray[i],
                    MainDataset.nameArray[i],
                    MainDataset.infoArray[i]
            ));
        }

    }

    public void clique(View view) {
//        currentItem = recyclerView.getChildAdapterPosition(view);
//        startActivity(new Intent(getApplicationContext(), DetailActivity.class));
    }

    private class MainOnClickListener implements View.OnClickListener {

        private final Context context;

        private MainOnClickListener(Context context) {
            this.context = context;
        }


        @Override
        public void onClick(View v) {
            currentItem = recyclerView.getChildAdapterPosition(v);
            startActivity(new Intent(getApplicationContext(), DetailActivity.class));
        }
    }


}
