package com.bridgelabz.censusanalyser;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/*
    @desc: test file for the project
 */
public class StateCensusAnalyserTest {
    private static final String CSV_FILE_PATH = "data/StateCensus.csv";
    private StateCensusAnalyser analyser;
    private List<CSVStateCensus> censusDataList;
    /*
        @desc: setup function for test file
        @params: none
        @return: void
     */
    @Before
    public void setup(){
        this.analyser = new StateCensusAnalyser();
        try {
            this.censusDataList = analyser.loadCensusData(CSV_FILE_PATH);
        }catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    /*
        @desc: test for checking records count: happy tc
        @params: none
        @return: void
     */
    @Test
    public void ShouldReturnCorrectRecordsCount() {
            int numberOfRecords = analyser.getNumberOfRecords();
            int expectedCount = 37;
            assertEquals("Number of records mismatch",expectedCount, numberOfRecords);
    }
}
