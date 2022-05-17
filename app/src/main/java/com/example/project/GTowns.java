package com.example.networking;

public class GTowns {
    String name;
    String location;
    int size;

    public GTowns(String name, String location, int size) {
        this.name = name;
        this.location = location;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getName() {
        return name;
    }

    public void setName(String mountainName) {
        this.name = mountainName;
    }
}