package com.example.soccerteam.excepetion;

public class TeamNotFound extends RuntimeException {
    public TeamNotFound() {
        super("Team not found.");
    }

    public TeamNotFound(String message) {
        super(message);
    }
}

