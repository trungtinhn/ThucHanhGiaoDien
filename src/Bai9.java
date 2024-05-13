/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai9 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField textField = new JTextField(15);
        JRadioButton normalRadioButton = new JRadioButton("Thường");
        JRadioButton boldRadioButton = new JRadioButton("Bôi đậm");
        JRadioButton italicRadioButton = new JRadioButton("In nghiêng");
        JRadioButton boldItalicRadioButton = new JRadioButton("Bôi đậm và in nghiêng");

        ButtonGroup group = new ButtonGroup();
        group.add(normalRadioButton);
        group.add(boldRadioButton);
        group.add(italicRadioButton);
        group.add(boldItalicRadioButton);

        ActionListener styleListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font font = textField.getFont();
                int style = Font.PLAIN;
                if (boldRadioButton.isSelected()) {
                    style = Font.BOLD;
                } else if (italicRadioButton.isSelected()) {
                    style = Font.ITALIC;
                } else if (boldItalicRadioButton.isSelected()) {
                    style = Font.BOLD | Font.ITALIC;
                }
                textField.setFont(new Font(font.getFontName(), style, font.getSize()));
            }
        };

        normalRadioButton.addActionListener(styleListener);
        boldRadioButton.addActionListener(styleListener);
        italicRadioButton.addActionListener(styleListener);
        boldItalicRadioButton.addActionListener(styleListener);

        frame.add(textField);
        frame.add(normalRadioButton);
        frame.add(boldRadioButton);
        frame.add(italicRadioButton);
        frame.add(boldItalicRadioButton);
        frame.setVisible(true);
    }
}
