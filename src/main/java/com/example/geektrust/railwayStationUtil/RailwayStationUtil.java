package com.example.geektrust.railwayStationUtil;

import com.example.geektrust.Bogie;
import com.example.geektrust.Station;
import com.example.geektrust.Stop;
import com.example.geektrust.Train;
import com.example.geektrust.util.FileOutput;

import java.util.HashMap;
import java.util.Map;

public class RailwayStationUtil {
    public RailwayStationUtil() {
        this.bogie = new Bogie();
    }

    private Bogie bogie;

    public void printArrivalAndDeparture(String trainAArrival, String trainBArrival) {
        FileOutput output = new FileOutput();
        output.write("ARRIVAL " + trainAArrival);
        output.write("\n");
        output.write("ARRIVAL " + trainBArrival);
        output.write("\n");

        String trainAB = bogie.merge(trainAArrival, trainBArrival);

        if (trainAB.split(" ").length == 3) {
            output.write("JOURNEY_ENDED");
        }
        else {
            output.write("DEPARTURE " + trainAB);
        }

        output.printToConsole();
    }

    public void initializeTrainWithItsStops(Train train, String data) {
        for(String stationData : data.split("\n")) {
            int indexOfOpeningBracket = stationData.indexOf('(');
            int indexOfClosingBracket = stationData.indexOf(')');

            String stationName = stationData.substring(0, indexOfOpeningBracket - 1);
            String stationCode = stationData.substring(indexOfOpeningBracket + 1, indexOfClosingBracket);
            long distance = Long.parseLong(stationData.substring(indexOfClosingBracket + 2));

            Station station = new Station(stationName, stationCode);
            Stop stop = new Stop(station, distance);
            train.addStop(stop);
        }
    }
}
