/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea1 = new JTextArea(5, 20);
        JTextArea textArea2 = new JTextArea(5, 20);
        JButton button = new JButton("Copy");

        button.addActionListener((ActionEvent e) -> {
            textArea2.setText(textArea1.getSelectedText());
        });

        frame.add(textArea1);
        frame.add(button);
        frame.add(textArea2);
        frame.setVisible(true);
    }
}