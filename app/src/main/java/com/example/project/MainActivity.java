package com.example.project;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements com.example.networking.JsonTask.JsonTaskListener {
    private ArrayList<GTowns> gTownList;
    private RecyclerView recyclerView;
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=b21antbr";
    //private final String JSON_FILE = "mountains.json";
    com.example.networking.recyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerView);
        gTownList = new ArrayList<>();
        setAdapter();
        new com.example.networking.JsonTask(this).execute(JSON_URL);
    }
    private void setAdapter(){
        adapter = new com.example.networking.recyclerAdapter(gTownList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<GTowns>>() {}.getType();
        ArrayList<Gtowns> listOfGTowns = gson.fromJson(json, type);
        gTownList.addAll(listOfGTowns);
        adapter.notifyDataSetChanged();
    }

}

}
