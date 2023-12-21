package com.example.geektrust;

public class Station {
    private final String name;
    private final String code;

    public Station(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
