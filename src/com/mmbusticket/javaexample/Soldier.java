package com.mmbusticket.javaexample;

public class Soldier {
    int currentLocation;

    void shoot() {
        System.out.println("Bang Bang!");
    }

    void moveForward() {
        this.currentLocation++;
    }

    void moveBackward() {
        this.currentLocation--;
    }
}
