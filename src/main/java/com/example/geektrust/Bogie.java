package com.example.geektrust;

import com.example.geektrust.bogieUtils.BogieUtil;

import java.util.*;

public class Bogie {
    public String merge(String trainA, String trainB) {
        String[] boggiesOfA = trainA.split(" ");
        String[] boggiesOfB = trainB.split(" ");

        String[] merge = mergeTwoBogies(boggiesOfA, boggiesOfB);
        BogieUtil bogieUtil = new BogieUtil();

        merge = bogieUtil.removeNullValue(merge);
        bogieUtil.sortBoggiesInDescOrderOfDistance(merge);

        return bogieUtil.convertBogieToTrain(merge);
    }

    private String[] mergeTwoBogies(String[] boggiesOfA, String[] boggiesOfB) {
        int newBoggyLength = boggiesOfA.length + boggiesOfB.length - 1;
        String[] merge = new String[newBoggyLength];

        merge[0] = "TRAIN_AB";
        merge[1] = boggiesOfA[1];
        merge[2] = boggiesOfB[1];

        int idxToMerge = 3;
        int startIdx = 2;

        for(int i = startIdx ; i < boggiesOfA.length ; i++) {
            if(boggiesOfA[i].equals("HYB")) {
                continue;
            }

            merge[idxToMerge++] = boggiesOfA[i];
        }

        for (int i = startIdx ; i < boggiesOfB.length ; i++) {
            if(boggiesOfB[i].equals("HYB")) {
                continue;
            }

            merge[idxToMerge++] = boggiesOfB[i];
        }

        return merge;
    }
}
