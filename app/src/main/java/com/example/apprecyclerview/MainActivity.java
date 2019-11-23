package com.example.apprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MainData> data;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<>();
        recyclerView = findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        llenarData();
        RecyclerView.Adapter adapter = new MainAdapter(data);
        recyclerView.setAdapter(adapter);
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
