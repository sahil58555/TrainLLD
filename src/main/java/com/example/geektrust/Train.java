package com.example.geektrust;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Train {
    private final List<Stop> stops;
    private final int limit;

    public Train(int limit) {
        this.stops = new ArrayList<>();
        this.limit = limit;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void addStop(Stop stop) {
        stops.add(stop);
    }

    public Set<String> getAllStopsBeforeHYD() {

        return stops.stream().map(stop -> stop.getStation().getCode()).limit(limit).collect(Collectors.toSet());
    }
    public String getArrival(String trainInput) {
        Set<String> stopBeforeHYD = getAllStopsBeforeHYD();

        String[] boggies = trainInput.split(" ");

        StringBuilder arrivalData = new StringBuilder();

        for(int i = 0 ; i < boggies.length ; i++) {
            if(!stopBeforeHYD.contains(boggies[i])) {
                arrivalData.append(boggies[i]);
                arrivalData.append(" ");
            }
        }

        return arrivalData.toString();
    }
}
