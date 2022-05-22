package com.example.project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<GTowns> gTownList;

    public recyclerAdapter(ArrayList<GTowns> gTownList){
        this.gTownList = gTownList;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView gTownText;
        public ImageView gTownImage;
        public TextView gTownName;
        public MyViewHolder(final View view) {
            super(view);
            gTownImage = view.findViewById(R.id.gTownImageView);
            gTownText = view.findViewById(R.id.gTownName);
            gTownName = view.findViewById(R.id.gTownNameBig);
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
        int population = gTownList.get(position).getPopulation();
        String image = gTownList.get(position).getAuxdata();
        Picasso.get().load(image).into(holder.gTownImage);
        holder.gTownName.setText(name);
        holder.gTownText.setText("Location: " + location + "\nPopulation: " + population);


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