package com.thoughtworks.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by peter on 2016/9/20 0020.
 */
public class Snapshot {
    private String id;
    private Date time;
    private LinkedList<AnimalLocation> locations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public LinkedList<AnimalLocation> getLocations() {
        return locations;
    }

    public void setLocations(LinkedList<AnimalLocation> locations) {
        this.locations = locations;
    }
}
