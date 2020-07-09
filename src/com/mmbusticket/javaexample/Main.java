package com.mmbusticket.javaexample;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.TimerTask;

public class Main {
    public static int PANEL_WIDTH = 800;
    public static int PANEL_HEIGHT = 600;
    public static int scale = 1;

    public static void main(String[] args) {
        createWindow();
    }

    public static void drawRectCenter(Graphics g, int panelWidth, int panelHeight, int rectWidth, int rectHeight) {
        g.drawRect(
                (panelWidth/2) - (rectWidth/2),
                (panelHeight/2) - (rectHeight/2),
                rectWidth,
                rectHeight);
    }

    public static void drawOvalCenter(Graphics g, int panelWidth, int panelHeight, int rectWidth, int rectHeight) {
        g.drawOval(
                (panelWidth/2) - (rectWidth/2),
                (panelHeight/2) - (rectHeight/2),
                rectWidth,
                rectHeight);
    }

    public static void drawBall(Ball ball, Graphics g) {
        g.drawOval(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius());
    }

    public static void createWindow() {
        final double gravity = 1;
        Ball ball1 = new Ball(PANEL_WIDTH/2, 2 * PANEL_HEIGHT/3, 50, 0.0, -30);
        Ball ball2 = new Ball((PANEL_WIDTH/2) + 100, 2 * PANEL_HEIGHT/3, 40, 0.0, -35);

        JFrame frame = new JFrame("JFrame Example");
        final JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);

                g.setColor(Color.BLACK);
                g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

                g.setColor(Color.YELLOW);

                drawBall(ball1, g);
                drawBall(ball2, g);
            }
        };
        frame.add(panel);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        TimerTask task = new TimerTask() {
            public void run() {
                ball1.calculateNextStep(gravity);
                ball2.calculateNextStep(gravity);
                panel.repaint();
            }
        };
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(task, 66L, 66L);
    }
}
