/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton leftButton = new JButton("Trái");
        JButton rightButton = new JButton("Phải");
        JButton topButton = new JButton("Trên");
        JButton bottomButton = new JButton("Dưới");
        JButton centerButton = new JButton("Giữa");

        ActionListener hideListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                button.setVisible(false);
                frame.revalidate();
                frame.repaint();
            }
        };

        leftButton.addActionListener(hideListener);
        rightButton.addActionListener(hideListener);
        topButton.addActionListener(hideListener);
        bottomButton.addActionListener(hideListener);
        centerButton.addActionListener(hideListener);

        frame.add(leftButton, BorderLayout.WEST);
        frame.add(rightButton, BorderLayout.EAST);
        frame.add(topButton, BorderLayout.NORTH);
        frame.add(bottomButton, BorderLayout.SOUTH);
        frame.add(centerButton, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
