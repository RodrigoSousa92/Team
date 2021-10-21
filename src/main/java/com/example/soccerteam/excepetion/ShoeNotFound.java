package com.example.soccerteam.excepetion;

public class ShoeNotFound extends RuntimeException {
    public ShoeNotFound() {
        super("Shoe not found.");
    }

    public ShoeNotFound(String message) {
        super(message);
    }

}
