package com.thoughtworks.model;

public class AnimalLocation {
    private String name;
    private Location location;

    public AnimalLocation(String detail) {
        String[] items = detail.split(" ");
        this.name = items[0];
        location = new Location(Integer.parseInt(items[1]),Integer.parseInt(items[2]));
    }

    public boolean updateLocation(Location preLocation,String detail,String id) {
        if (preLocation.equals(location)) {
            String[] items = detail.split(" ");
            location.setX(location.getX() + Integer.parseInt(items[3]));
            location.setY(location.getY() + Integer.parseInt(items[4]));
            return true;
        } else {
            throw new IllegalArgumentException("Conflict found at "+id);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimalLocation that = (AnimalLocation) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return location != null ? location.equals(that.location) : that.location == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name+" "+location.toString();
    }
}
