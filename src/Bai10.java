/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai10 extends JFrame {
    private JTextArea textArea;

    public Bai10() {
        setTitle("Menu Example");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem aboutItem = new JMenuItem("About");
        JMenuItem exitItem = new JMenuItem("Exit");

        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Bai10.this, "This is a simple menu example.", "About",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fileMenu.add(aboutItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        JMenu formatMenu = new JMenu("Format");
        JMenu colorMenu = new JMenu("Color");
        JMenuItem redItem = new JMenuItem("Red");
        JMenuItem greenItem = new JMenuItem("Green");
        JMenuItem blueItem = new JMenuItem("Blue");

        redItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.RED);
            }
        });

        greenItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.GREEN);
            }
        });

        blueItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.BLUE);
            }
        });

        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);

        JMenu fontMenu = new JMenu("Font");
        JRadioButtonMenuItem arialItem = new JRadioButtonMenuItem("Arial");
        JRadioButtonMenuItem timesNewItem = new JRadioButtonMenuItem("Times New Roman");
        JRadioButtonMenuItem courierItem = new JRadioButtonMenuItem("Courier");

        ButtonGroup fontGroup = new ButtonGroup();
        fontGroup.add(arialItem);
        fontGroup.add(timesNewItem);
        fontGroup.add(courierItem);

        fontMenu.add(arialItem);
        fontMenu.add(timesNewItem);
        fontMenu.add(courierItem);

        JCheckBoxMenuItem boldItem = new JCheckBoxMenuItem("Bold");
        JCheckBoxMenuItem italicItem = new JCheckBoxMenuItem("Italic");

        boldItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int style = Font.PLAIN;
                if (boldItem.isSelected()) {
                    style |= Font.BOLD;
                }
                if (italicItem.isSelected()) {
                    style |= Font.ITALIC;
                }
                textArea.setFont(new Font(textArea.getFont().getName(), style, textArea.getFont().getSize()));
            }
        });

        italicItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int style = Font.PLAIN;
                if (boldItem.isSelected()) {
                    style |= Font.BOLD;
                }
                if (italicItem.isSelected()) {
                    style |= Font.ITALIC;
                }
                textArea.setFont(new Font(textArea.getFont().getName(), style, textArea.getFont().getSize()));
            }
        });

        formatMenu.add(colorMenu);
        formatMenu.add(fontMenu);
        formatMenu.addSeparator();
        formatMenu.add(boldItem);
        formatMenu.add(italicItem);

        menuBar.add(formatMenu);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Bai10 example = new Bai10();
            example.setVisible(true);
        });
    }
}
