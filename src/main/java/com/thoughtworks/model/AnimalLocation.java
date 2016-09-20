package com.thoughtworks.model;

/**
 * Created by peter on 2016/9/20 0020.
 */
public class AnimalLocation {
    private String name;
    private Location location;

    public AnimalLocation(String detail) {
        String[] items = detail.split(" ");
        this.name = items[0];
        location = new Location(Integer.parseInt(items[1]),Integer.parseInt(items[2]));
    }

    public boolean updateLocation(Location preLocation,String detail) {
        if (preLocation.equals(location)) {
            String[] items = detail.split(" ");
            location.setX(location.getX() + Integer.parseInt(items[3]));
            location.setY(location.getY() + Integer.parseInt(items[4]));
            return true;
        } else {
            throw new IllegalArgumentException("Conflict argument");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }



}
