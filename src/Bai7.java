/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;

public class Bai7 extends JFrame {
    private JPanel colorPanel;

    public Bai7() {
        setTitle("Chọn màu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        colorPanel = new JPanel();
        colorPanel.setBackground(Color.WHITE);
        mainPanel.add(colorPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1));

        JRadioButton redButton = new JRadioButton("Đỏ");
        redButton.addActionListener(e -> changeColor(Color.RED));

        JRadioButton greenButton = new JRadioButton("Xanh lá");
        greenButton.addActionListener(e -> changeColor(Color.GREEN));

        JRadioButton blueButton = new JRadioButton("Xanh dương");
        blueButton.addActionListener(e -> changeColor(Color.BLUE));

        ButtonGroup group = new ButtonGroup();
        group.add(redButton);
        group.add(greenButton);
        group.add(blueButton);

        buttonPanel.add(redButton);
        buttonPanel.add(greenButton);
        buttonPanel.add(blueButton);

        mainPanel.add(buttonPanel, BorderLayout.EAST);

        getContentPane().add(mainPanel);
    }

    private void changeColor(Color color) {
        colorPanel.setBackground(color);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Bai7 example = new Bai7();
            example.setVisible(true);
        });
    }
}
