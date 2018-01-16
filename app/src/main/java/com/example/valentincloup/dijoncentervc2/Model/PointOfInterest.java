package com.example.valentincloup.dijoncentervc2.Model;

/**
 * Created by Valentin CLOUP on 20/09/2017.
 */

public class PointOfInterest
{
    private String id;
    private String type;
    private String name;
    private Location location;
    private Position position;

    public PointOfInterest() {}

    public PointOfInterest(String id, String type, String name, Location location, Position position) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.name = name;
        this.position = position;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
