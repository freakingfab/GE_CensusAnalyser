package com.bridgelabz.censusanalyser;

/*
    @desc: class for storing object of each state
 */
public class CSVStateCensus {
    private int srNo;
    private String stateName;
    private int tin;
    private String stateCode;

    /*
        @desc: constructor for the class
        @params: class variables
        @return: none
     */
    public CSVStateCensus(int srNo, String stateName, int tin, String stateCode) {
        this.srNo = srNo;
        this.stateName = stateName;
        this.tin = tin;
        this.stateCode = stateCode;
    }

    /*
        @desc: getter for class variables
     */
    public int getSrNo(){
        return this.srNo;
    }

    public String getStateName() {
        return stateName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public int getTin() {
        return tin;
    }
}
