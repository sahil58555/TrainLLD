package com.example.geektrust.bogieUtils;

import com.example.geektrust.RailwayStation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BogieUtil {
    public String convertBogieToTrain(String[] bogies) {
        StringBuilder trainAB = new StringBuilder();

        for(String bogie : bogies) {
            trainAB.append(bogie);
            trainAB.append(" ");
        }

        return trainAB.toString();
    }

    public String[] removeNullValue(String[] boggies) {
        List<String> newBoggies = new ArrayList<>();

        for(String bogie : boggies) {
            if(bogie != null) {
                newBoggies.add(bogie);
            }
        }

        return newBoggies.toArray(new String[0]);
    }

    public String removeEmptyBoggies(String boggies) {
        StringBuilder newBoggy = new StringBuilder();

        for(String boggy : boggies.split(" ")) {
            if(!boggy.isEmpty()) {
                newBoggy.append(boggy);
                newBoggy.append(" ");
            }
        }

        return newBoggy.toString();
    }

    public void sortBoggiesInDescOrderOfDistance(String[] boggies) {
        Map<String, Long> map = new RailwayStation().getStationDistanceMap();

        Arrays.sort(boggies, 3, boggies.length, (boggy1, boggy2) -> {
            return -Long.compare(map.get(boggy1), map.get(boggy2));
        });
    }
}
