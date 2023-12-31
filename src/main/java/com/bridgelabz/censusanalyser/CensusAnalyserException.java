package com.bridgelabz.censusanalyser;

/*
    @desc: exception handler class
 */
public class CensusAnalyserException extends Exception{
    enum ExceptionType {

        CENSUS_FILE_PROBLEM,
        CENSUS_INCORRECT_DELIMITER
    }

    ExceptionType type;

    /*
        @desc: constructor for the class
        @params: message and type
        @return: none
     */
    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
