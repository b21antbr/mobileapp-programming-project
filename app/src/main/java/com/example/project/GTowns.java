package com.example.project;

import com.google.gson.annotations.SerializedName;

public class GTowns {
    String name;
    String location;
    @SerializedName("size")
    int population;

    public GTowns(String name, String location, int population) {
        this.name = name;
        this.location = location;
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

}