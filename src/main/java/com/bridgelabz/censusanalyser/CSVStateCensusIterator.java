package com.bridgelabz.censusanalyser;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

public class CSVStateCensusIterator implements Iterator {
    private BufferedReader reader;
    private String currentLine;
    private boolean headerSkipped = false;

    /*
        @desc: constructor for class
        @params: none
        @return: none
     */
    public CSVStateCensusIterator(BufferedReader reader) {
        this.reader = reader;
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
                reader.readLine();
                headerSkipped = true;
            }
            currentLine = reader.readLine();
            return currentLine != null;
        } catch (IOException e) {
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
        String[] data = currentLine.split(",");
        int srNo = Integer.parseInt(data[0].substring(1));
        String stateName = data[1];
        int tin = Integer.parseInt(data[2]);
        String stateCode = data[3].substring(0, data[3].length() - 1);
        return new CSVStateCensus(srNo, stateName, tin, stateCode);
    }
}
