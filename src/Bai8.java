import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Bai8 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Chọn một file hình ảnh");
        JButton button = new JButton("Chọn file");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
                    label.setIcon(icon);
                }
            }
        });

        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
    }
}