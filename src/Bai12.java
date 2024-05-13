/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class Bai12 extends JPanel {
    private int circleSize = 50;

    public Bai12() {
        setPreferredSize(new Dimension(400, 400));
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 10, 200, circleSize);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                circleSize = slider.getValue();
                repaint();
            }
        });
        add(slider);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        g.setColor(Color.BLUE);
        g.fillOval(centerX - circleSize / 2, centerY - circleSize / 2, circleSize, circleSize);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Bai12());
        frame.pack();
        frame.setVisible(true);
    }
}
