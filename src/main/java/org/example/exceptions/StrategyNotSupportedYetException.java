package org.example.exceptions;

public class StrategyNotSupportedYetException extends IllegalArgumentException {
    public StrategyNotSupportedYetException(String strategy) {
        super(strategy + " is not supported yet");
    }
}