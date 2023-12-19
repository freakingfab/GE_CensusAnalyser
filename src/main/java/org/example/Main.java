package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StateCensusAnalyser analyser = new StateCensusAnalyser();
        try {
            List censusDataList = analyser.loadCensusData("data/StateCensus.csv");
            System.out.println("Number of records: " + analyser.getNumberOfRecords());
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
}