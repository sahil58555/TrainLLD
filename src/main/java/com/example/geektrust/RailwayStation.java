package com.example.geektrust;

import com.example.geektrust.bogieUtils.BogieUtil;
import com.example.geektrust.railwayStationUtil.RailwayStationUtil;
import com.example.geektrust.sampleData.TrainData;
import com.example.geektrust.util.FileInput;
import com.example.geektrust.util.FileOutput;

import java.util.*;
import java.util.stream.Collectors;

public class RailwayStation {
    private final Train trainA;
    private final Train trainB;

    private final RailwayStationUtil railwayStationUtil;

    private final BogieUtil bogieUtil;


    public Train getTrainA() {
        return trainA;
    }

    public Train getTrainB() {
        return trainB;
    }

    public RailwayStation() {
        trainA = new Train(4);
        trainB = new Train(5);
        railwayStationUtil = new RailwayStationUtil();
        bogieUtil = new BogieUtil();
        init();
    }
    private void init() {
        TrainData trainData = new TrainData();
        String data = trainData.loadDataFromTrainA();
        railwayStationUtil.initializeTrainWithItsStops(trainA, data);

        data = trainData.loadDataFromTrainB();
        railwayStationUtil.initializeTrainWithItsStops(trainB, data);
    }

    public void mergeTrain(String path) {
        FileInput input = new FileInput();

        String data = input.getInputDataFromFile(path);
        String trainAInput = data.split("\n")[0];
        String trainBInput = data.split("\n")[1];

        trainAInput = bogieUtil.removeEmptyBoggies(trainAInput);
        trainBInput = bogieUtil.removeEmptyBoggies(trainBInput);

        String trainAArrival = trainA.getArrival(trainAInput);
        String trainBArrival = trainB.getArrival(trainBInput);

        railwayStationUtil.printArrivalAndDeparture(trainAArrival, trainBArrival);
    }

    public Map<String, Long> getStationDistanceMap() {
        Map<String, Long> map = new HashMap<>();

        for(Stop stop : trainB.getStops()) {
            map.put(stop.getStation().getCode(), stop.getDistance());
        }

        for(Stop stop : trainA.getStops()) {
            map.put(stop.getStation().getCode(), stop.getDistance());
        }

        return map;
    }
}
