
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
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                if (button.getText().equals("Trái")) {
                    setAlignment(leftButton, Component.LEFT_ALIGNMENT);
                    setAlignment(centerButton, Component.LEFT_ALIGNMENT);
                    setAlignment(rightButton, Component.LEFT_ALIGNMENT);
                } else if (button.getText().equals("Giữa")) {
                    setAlignment(leftButton, Component.CENTER_ALIGNMENT);
                    setAlignment(centerButton, Component.CENTER_ALIGNMENT);
                    setAlignment(rightButton, Component.CENTER_ALIGNMENT);
                } else if (button.getText().equals("Phải")) {
                    setAlignment(leftButton, Component.RIGHT_ALIGNMENT);
                    setAlignment(centerButton, Component.RIGHT_ALIGNMENT);
                    setAlignment(rightButton, Component.RIGHT_ALIGNMENT);
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