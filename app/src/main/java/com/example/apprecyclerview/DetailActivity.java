package com.example.apprecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    private ArrayList<MainData> detailData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView detailImage = findViewById(R.id.detail_image);
        TextView detailName = findViewById(R.id.detail_name);
        TextView detailText = findViewById(R.id.detail_text);
        ImageView detailWeblink = findViewById(R.id.detail_weblink);

        detailText.setMovementMethod(new ScrollingMovementMethod());

        int i = mainOnClickListener.currentItem;
        setTitle(getString(R.string.app_name) + "-" + MainDataset.nameArray[i]);
        detailImage.setImageResource(MainDataset.detailImageArray[i]);
        detailName.setText(MainDataset.nameArray[i]);
        detailText.setText(MainDataset.detailTextArray[i]);

    }
}
