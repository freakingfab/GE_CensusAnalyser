package com.bridgelabz.censusanalyser;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    @desc: class for reading data from csv file
 */
public class StateCensusAnalyser {
    private List censusDataList;

    /*
        @desc: constructor for the class
        @params: none
        @return: none
     */
    public StateCensusAnalyser(){
        this.censusDataList = new ArrayList<>();
    }

    /*
        @desc: load census data from csv file
        @params: csv file path
        @return: List
     */
    public List loadCensusData(String csvFilePath, String delimiter) throws CensusAnalyserException {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            Iterator csvStateCensusIterator = new CSVStateCensusIterator(reader, delimiter);
            csvStateCensusIterator.forEachRemaining(censusDataList::add);
            return censusDataList;
        } catch (IOException e ) {
            throw new CensusAnalyserException("Error reading CSV file", CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    /*
        @desc:provides no. of records
        @params: none
        @return: int
     */
    public int getNumberOfRecords() {
        return censusDataList.size();
    }
}
