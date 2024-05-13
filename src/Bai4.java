/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton leftButton = new JButton("Trái");
        JButton centerButton = new JButton("Giữa");
        JButton rightButton = new JButton("Phải");

        ActionListener alignListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                switch (button.getText()) {
                    case "Trái" -> {
                        setAlignment(leftButton, Component.LEFT_ALIGNMENT);
                        setAlignment(centerButton, Component.LEFT_ALIGNMENT);
                        setAlignment(rightButton, Component.LEFT_ALIGNMENT);
                    }
                    case "Giữa" -> {
                        setAlignment(leftButton, Component.CENTER_ALIGNMENT);
                        setAlignment(centerButton, Component.CENTER_ALIGNMENT);
                        setAlignment(rightButton, Component.CENTER_ALIGNMENT);
                    }
                    case "Phải" -> {
                        setAlignment(leftButton, Component.RIGHT_ALIGNMENT);
                        setAlignment(centerButton, Component.RIGHT_ALIGNMENT);
                        setAlignment(rightButton, Component.RIGHT_ALIGNMENT);
                    }
                    default -> {
                    }
                }
            }

            private void setAlignment(JComponent component, float alignment) {
                component.setAlignmentX(alignment);
                component.setAlignmentY(alignment);
            }
        };

        leftButton.addActionListener(alignListener);
        centerButton.addActionListener(alignListener);
        rightButton.addActionListener(alignListener);

        frame.add(leftButton);
        frame.add(centerButton);
        frame.add(rightButton);
        frame.setVisible(true);
    }
}
