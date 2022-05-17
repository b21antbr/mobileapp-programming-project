package com.example.networking;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;

import java.util.ArrayList;

class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<GTowns> gTownList;

    public recyclerAdapter(ArrayList<GTowns> gTownList){
        this.gTownList = mountainList;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView gTownText;


        public MyViewHolder(final View view) {
            super(view);
            gTownText = view.findViewById(R.id.gTownName);
        }
    }
    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = gTownList.get(position).getName();
        String location = gTownList.get(position).getLocation();
        int size = gTownList.get(position).getSize();
        holder.gTownText.setText("input for info");
    }

    @Override
    public int getItemCount() {
        return gTownList.size();
    }

    public void addGTowns(ArrayList<GTowns> gTownList){
        this.gTownList.addAll(gTownList);
        notifyDataSetChanged();
    }
}