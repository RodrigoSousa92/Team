package com.example.soccerteam.excepetion;

public class PlayerNotFound extends RuntimeException {
    public PlayerNotFound() {
        super("Player not found.");
    }

    public PlayerNotFound(String message) {
        super(message);
    }
}

