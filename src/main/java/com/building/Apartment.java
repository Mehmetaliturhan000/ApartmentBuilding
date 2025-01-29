package com.building;

public class Apartment extends Room {
    private String ownerName;

    public Apartment(String id, String ownerName, double tolerance, double initialRate, double decayFactor) {
        super(id, tolerance, initialRate, decayFactor);
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return super.toString() + ", Owner: " + ownerName;
    }
}
