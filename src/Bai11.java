/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class Bai11 extends JPanel {
    private final int NUM_STARS = 20;
    private final int STAR_SIZE = 30;
    private final Random random = new Random();

    public Bai11() {
        setPreferredSize(new Dimension(400, 400));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        for (int i = 0; i < NUM_STARS; i++) {
            int x = (int) (centerX + STAR_SIZE * Math.cos(2 * Math.PI * i / NUM_STARS));
            int y = (int) (centerY + STAR_SIZE * Math.sin(2 * Math.PI * i / NUM_STARS));
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            drawStar(g2d, x, y, STAR_SIZE, color);
        }
    }

    private void drawStar(Graphics2D g2d, int x, int y, int size, Color color) {
        g2d.setColor(color);
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];

        for (int i = 0; i < 10; i++) {
            double angle = Math.PI / 5 * i;
            double radius = (i % 2 == 0) ? size : size / 2;
            xPoints[i] = x + (int) (radius * Math.cos(angle));
            yPoints[i] = y + (int) (radius * Math.sin(angle));
        }

        g2d.fill(new Polygon(xPoints, yPoints, 10));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Star Drawing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Bai11());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
