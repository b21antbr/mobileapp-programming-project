package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<Islands> islandList;

    public recyclerAdapter(ArrayList<Islands> gTownList){
        this.islandList = gTownList;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView islandText;
        public ImageView islandImage;
        public TextView islandName;
        public MyViewHolder(final View view) {
            super(view);
            islandImage = view.findViewById(R.id.islandImage);
            islandText = view.findViewById(R.id.islandText);
            islandName = view.findViewById(R.id.islandName);
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
        String name = islandList.get(position).getName();
        String location = islandList.get(position).getLocation();
        int population = islandList.get(position).getPopulation();
        String image = islandList.get(position).getAuxdata();
        Picasso.get().load(image).into(holder.islandImage);
        holder.islandName.setText(name);
        holder.islandText.setText("Location: " + location + "\nPopulation: " + population);


    }

    @Override
    public int getItemCount() {
        return islandList.size();
    }

    public void addIsland(ArrayList<Islands> islandList){
        this.islandList.addAll(islandList);
        notifyDataSetChanged();
    }
}