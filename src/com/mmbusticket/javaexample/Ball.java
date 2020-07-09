package com.mmbusticket.javaexample;

public class Ball {
    private int x;
    private int y;
    private int radius;

    private double vx;
    private double vy;

    public Ball(int x, int y, int radius, double vx, double vy) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.vx = vx;
        this.vy = vy;
    }

    public void calculateNextStep(double gravity) {
        y = (int) (y + vy);
        vy = vy + gravity;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public double getVx() {
        return vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }
}
