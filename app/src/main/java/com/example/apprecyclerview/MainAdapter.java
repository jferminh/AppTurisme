package com.example.apprecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private ArrayList<MainData> mainData;

    public MainAdapter(ArrayList<MainData> mainData) {
        this.mainData = mainData;
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgImage;
        private final TextView txtName;
        private final TextView txtInfo;

        public MainViewHolder(View itemView) {
            super(itemView);
            this.imgImage = itemView.findViewById(R.id.imgImage);
            this.txtName = itemView.findViewById(R.id.txtName);
            this.txtInfo = itemView.findViewById(R.id.txtInfo);
        }


    }

    @NonNull
    @Override
    public MainAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lieu_card, parent, false);
        view.setOnClickListener(MainActivity.mainOnClickListener);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainViewHolder holder, int position) {
        ImageView imgImage = holder.imgImage;
        TextView txtName = holder.txtName;
        TextView txtInfo = holder.txtInfo;
        imgImage.setImageResource(mainData.get(position).getImage());
        txtName.setText(mainData.get(position).getName());
        txtInfo.setText(mainData.get(position).getInfo());

    }

    @Override
    public int getItemCount() {
        return mainData.size();
    }


}
