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

public class Bai6 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        String[] genres = { "Văn học", "Khoa học", "Lịch sử", "Công nghệ", "Thể thao", "Văn hóa" };
        JList<String> list = new JList<>(genres);
        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thể loại sách bạn đã chọn: " + list.getSelectedValuesList());
            }
        });

        frame.add(new JScrollPane(list));
        frame.add(submitButton);
        frame.setVisible(true);
    }
}
