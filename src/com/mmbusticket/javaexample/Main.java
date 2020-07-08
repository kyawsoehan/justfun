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

    public static void createWindow() {

        JFrame frame = new JFrame("JFrame Example");
        final JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);

                g.setColor(Color.BLACK);
                g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

                g.setColor(Color.YELLOW);

                for(int i=0; i<10; i++) {
                    drawRectCenter(g, PANEL_WIDTH, PANEL_HEIGHT,
                            i * (20+scale), i * (20+scale));
                }
            }
        };
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        TimerTask task = new TimerTask() {
            public void run() {
                scale++;
                System.out.println("Scale " + scale);
                panel.repaint();
            }
        };
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(task, 66L, 66L);
    }
}
