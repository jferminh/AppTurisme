package com.example.apprecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class DetailActivity extends AppCompatActivity {
    private ArrayList<MainData> detailData;
    private static final int MIN_DISTANCE = 150;
    private static final int OFF_PATH = 100;
    private static final int VELOCITY_THRESHOLD = 75;
    private GestureDetector detector;
    View.OnTouchListener listener;
    private int ImageIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView detailImage = findViewById(R.id.detail_image);
        TextView detailName = findViewById(R.id.detail_name);
        TextView detailText = findViewById(R.id.detail_text);
        detailText.setMovementMethod(new ScrollingMovementMethod());

        int i = MainActivity.currentItem;
        setTitle(getString(R.string.app_name) + "-" + MainDataset.nameArray[i]);
        detailImage.setImageResource(MainDataset.detailImageArray[i]);
        detailName.setText(MainDataset.nameArray[i]);
        detailText.setText(MainDataset.detailTextArray[i]);


// onTouch
        detector = new GestureDetector(this, new GalleryGestureDetector());
        listener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return detector.onTouchEvent(event);
            }
        };
        ImageIndex = 0;
        detailImage.setOnTouchListener(listener);

    }

    private class GalleryGestureDetector implements GestureDetector.OnGestureListener {
        private int item;
        ImageView detailImage = findViewById(R.id.detail_image);


        {
            item = MainActivity.currentItem;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {

            detailImage.setElevation(4);

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (Math.abs(e1.getY() - e2.getY()) > OFF_PATH) return false;
            if (MainDataset.galleryArray[item].length != 0) {
                if (e1.getX() - e2.getX() > MIN_DISTANCE &&
                        Math.abs(velocityX) > VELOCITY_THRESHOLD){
                    ImageIndex++;
                    if (ImageIndex == MainDataset.galleryArray[item].length) ImageIndex = 0;
                    detailImage.setImageResource(MainDataset.galleryArray[item][ImageIndex]);
                } else {
                    if (e2.getX() - e1.getX() > MIN_DISTANCE &&
                    Math.abs(velocityX) > VELOCITY_THRESHOLD){
                        ImageIndex--;
                        if (ImageIndex < 0) ImageIndex = MainDataset.galleryArray[item].length - 1;
                        detailImage.setImageResource(MainDataset.galleryArray[item][ImageIndex]);
                    }
                }
            }
            detailImage.setElevation(0);
            return true;
        }
    }
}
