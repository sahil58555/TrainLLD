package com.example.geektrust;

public class Stop {
    private Station station;
    private long distance;

    public Stop(Station station, long distance) {
        this.station = station;
        this.distance = distance;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }
}
