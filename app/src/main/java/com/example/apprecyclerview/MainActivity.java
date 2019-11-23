package com.example.apprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MainData> data;
    public RecyclerView recyclerView;
    public static View.OnClickListener mainOnClickListener;

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
        mainOnClickListener = new mainOnClickListener(this);
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
}
