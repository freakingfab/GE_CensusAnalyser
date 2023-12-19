package com.bridgelabz.censusanalyser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

/*
    @desc: provides iterative operation to read csv file
 */
public class CSVStateCensusIterator implements Iterator {
    private CSVReader reader;
    private String currentLine;
    private String delimiter;
    private boolean headerSkipped = false;

    /*
        @desc: constructor for class
        @params: none
        @return: none
     */
    public CSVStateCensusIterator(CSVReader reader, String delimiter) {
        this.reader = reader;
        this.delimiter = delimiter;
    }

    /*
        @desc: overriding function for hasNext
        @params: none
        @return: boolean
     */
    @Override
    public boolean hasNext() {
        try {
            if (!headerSkipped) {
                // Skip the header line
                reader.readNext();
                headerSkipped = true;
            }
            currentLine = Arrays.toString(reader.readNext());
            return currentLine != "null";
        } catch (IOException | CsvValidationException e) {
            return false;
        }
    }

    /*
        @desc: CSVStateCensus overide function
        @params: none
        @return: none
     */
    @Override
    public CSVStateCensus next() {
        try {
            String[] data = currentLine.split(delimiter);
            int srNo = Integer.parseInt(data[0].substring(1));
            String stateName = data[1];
            int tin = Integer.parseInt(data[2]);
            String stateCode = data[3].substring(0, data[3].length() - 1);
            return new CSVStateCensus(srNo, stateName, tin, stateCode);
        }
        catch(NumberFormatException e){
            System.err.println("Error: Incorrect Delimiter");
            return null;
        }
    }
}
