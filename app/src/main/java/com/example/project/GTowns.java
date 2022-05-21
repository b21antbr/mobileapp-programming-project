package com.example.project;

import com.google.gson.annotations.SerializedName;

public class GTowns {
    String name;
    String location;
    @SerializedName("size")
    int population;
    String auxdata;

    public GTowns(String name, String location, int population, String auxdata) {
        this.name = name;
        this.location = location;
        this.population = population;
        this.auxdata = auxdata;
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

    public String getAuxdata() {
        return auxdata;
    }
}