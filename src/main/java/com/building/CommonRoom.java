package com.building;

public class CommonRoom extends Room {
    private String type;

    public CommonRoom(String id, String type, double tolerance, double initialRate, double decayFactor) {
        super(id, tolerance, initialRate, decayFactor);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: " + type;
    }
}