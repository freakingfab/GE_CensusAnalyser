package com.bridgelabz.censusanalyser;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/*
    @desc: test file for the project
 */
public class StateCensusAnalyserTest {

    private StateCensusAnalyser analyser;
    /*
        @desc: setup function for test file
        @params: none
        @return: void
     */
    @Before
    public void setup(){
        this.analyser = new StateCensusAnalyser();
    }
    /*
        @desc: test for checking records count: happy tc
        @params: none
        @return: void
     */
    @Test
    public void ShouldReturnCorrectRecordsCount() {
        try {
            List censusDataList = analyser.loadCensusData("data/StateCensus.csv",",");
            int numberOfRecords = analyser.getNumberOfRecords();
            int expectedCount = 37;
            assertEquals("Number of records mismatch",expectedCount, numberOfRecords);
        } catch (CensusAnalyserException e) {
            assertEquals("Error reading CSV file", e.getMessage());
        }
    }
    /*
        @desc: test for checking csv file: sad tc
        @params: none
        @return: void
     */
    @Test
    public void givenIncorrectCSVFile() {
        try {
            List<CSVStateCensus> censusDataListNew = analyser.loadCensusData("StateCensus.csv",",");
        } catch (CensusAnalyserException e) {
            assertEquals("Error reading CSV file", e.getMessage());
        }
    }
    /*
        @desc: test for checking file type: sad tc
        @parasm: none
        @return: void
     */
    @Test
    public void givenCorrectCSVFileButIncorrectType() {
        try {
            List<CSVStateCensus> censusDataListNew = analyser.loadCensusData("data/StateCensus.xml",",");
        } catch (CensusAnalyserException e) {
            assertEquals("Error reading CSV file", e.getMessage());
        }
    }
    /*
        @desc: test for checking delimiter: sad tc
        @parasm: none
        @return: void
     */
    @Test
    public void givenCorrectCSVFileButIncorrectDelimiterType() {
        try {
            List<CSVStateCensus> censusDataListNew = analyser.loadCensusData("data/StateCensus.csv",";");
        } catch (CensusAnalyserException e) {
            assertEquals("Error: Incorrect Delimiter", e.getMessage());
        }
    }
}
