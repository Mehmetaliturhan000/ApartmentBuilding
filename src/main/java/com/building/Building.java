package com.building;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Building {
    private double requestedTemperature;
    private List<Room> rooms;

    public Building(double requestedTemperature) {
        this.requestedTemperature = requestedTemperature;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
        room.updateHeatingCoolingStatus(requestedTemperature);
    }

    public void setRequestedTemperature(double requestedTemperature) {
        this.requestedTemperature = requestedTemperature;
        recalculateRoomStatuses();
    }

    public void recalculateRoomStatuses() {
        for (Room room : rooms) {
            room.updateHeatingCoolingStatus(requestedTemperature);
        }
    }

    public void startTemperatureUpdateScheduler() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (Room room : rooms) {
                    room.updateTemperature();
                    room.updateHeatingCoolingStatus(requestedTemperature);
                }
                System.out.println("\nUpdated Room Statuses:");
                printRoomStatuses();
            }
        }, 0, 15000); // Recalculate every 15 seconds
    }

    public void printRoomStatuses() {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }
}