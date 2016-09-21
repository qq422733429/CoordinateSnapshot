package com.thoughtworks.model;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by peter on 2016/9/20 0020.
 */
public class Snapshot {
    private String id;
    private Date time;
    private LinkedList<AnimalLocation> locations;

    public Snapshot(String id) {
        this.locations = new LinkedList<>();
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snapshot snapshot = (Snapshot) o;

        if (id != null ? !id.equals(snapshot.id) : snapshot.id != null) return false;
        if (time != null ? !time.equals(snapshot.time) : snapshot.time != null) return false;
        return locations != null ? locations.equals(snapshot.locations) : snapshot.locations == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (locations != null ? locations.hashCode() : 0);
        return result;
    }

}
