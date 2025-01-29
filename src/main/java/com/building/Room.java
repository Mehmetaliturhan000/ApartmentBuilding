package com.building;

public class Room {
    private final String id;
    private double currentTemperature;
    private boolean heatingEnabled;
    private boolean coolingEnabled;
    private double tolerance; // Configurable tolerance per room
    private double temperatureChangeRate; // Dynamic rate of temperature change
    private final double initialRate; // Initial rate of temperature change
    private final double decayFactor; // Decay factor for the rate

    public Room(String id, double tolerance, double initialRate, double decayFactor) {
        this.id = id;
        this.currentTemperature = generateRandomTemperature();
        this.heatingEnabled = false;
        this.coolingEnabled = false;
        this.tolerance = tolerance;
        this.initialRate = initialRate;
        this.temperatureChangeRate = initialRate;
        this.decayFactor = decayFactor;
    }

    private double generateRandomTemperature() {
        return 10 + (Math.random() * 30); // Random temperature between 10 and 40
    }

    public String getId() {
        return id;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public boolean isHeatingEnabled() {
        return heatingEnabled;
    }

    public boolean isCoolingEnabled() {
        return coolingEnabled;
    }

    public void updateHeatingCoolingStatus(double requestedTemperature) {
        if (currentTemperature < requestedTemperature - tolerance) {
            heatingEnabled = true;
            coolingEnabled = false;
        } else if (currentTemperature > requestedTemperature + tolerance) {
            coolingEnabled = true;
            heatingEnabled = false;
        } else {
            heatingEnabled = false;
            coolingEnabled = false;
        }
    }

    public void updateTemperature() {
        if (heatingEnabled) {
            currentTemperature += temperatureChangeRate; // Gradual increase
        } else if (coolingEnabled) {
            currentTemperature -= temperatureChangeRate; // Gradual decrease
        }

        // Apply decay to the temperature change rate
        temperatureChangeRate *= decayFactor;

        // Ensure the rate doesn't drop below a minimum threshold
        if (temperatureChangeRate < 0.1) {
            temperatureChangeRate = 0.1;
        }
    }

    @Override
    public String toString() {
        return "Room ID: " + id + ", Temperature: " + currentTemperature + "°C, Heating: " + heatingEnabled + ", Cooling: " + coolingEnabled;
    }
}