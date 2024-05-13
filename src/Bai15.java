/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Bai15 extends javax.swing.JFrame {
	private FirePanel firePanel;

	public Bai15(int fireCount, Image[] fireSprites) {
		firePanel = new FirePanel(fireCount, fireSprites);
		initComponents();
		getContentPane().setLayout(new BorderLayout()); // Đặt layout của JFrame
		getContentPane().add(firePanel, BorderLayout.CENTER);
		setTitle("BT15");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(800, 600);
		setVisible(true);
	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));

		pack();
	}//

	class Fire {
		int x, y;
		int currentSpriteIndex = 0;

		public Fire(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void draw(Graphics g, Image[] fireSprites) {
			g.drawImage(fireSprites[currentSpriteIndex], x, y, null);
			currentSpriteIndex = (currentSpriteIndex + 1) % fireSprites.length;
		}
	}

	class FirePanel extends JPanel {
		private List<Fire> fires;
		private Image[] fireSprites;

		public FirePanel(int fireCount, Image[] fireSprites) {
			this.fireSprites = fireSprites;
			fires = new ArrayList<>();
		}

		public void initFires(int fireCount) {
			Random random = new Random();
			for (int i = 0; i < fireCount; i++) {
				int x = random.nextInt(getWidth());
				int y = random.nextInt(getHeight());
				fires.add(new Fire(x, y));
			}
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (Fire fire : fires) {
				fire.draw(g, fireSprites);
			}
			repaint();
		}

		public void setFireCount(int fireCount) {
			Random random = new Random();
			while (fires.size() < fireCount) {
				int x = random.nextInt(getWidth());
				int y = random.nextInt(getHeight());
				fires.add(new Fire(x, y));
			}
			while (fires.size() > fireCount) {
				fires.remove(fires.size() - 1);
			}
			repaint(); // Trigger repaint to reflect the change
		}
	}

	public static void main(String args[]) {
		Image[] fireSprites = new Image[25];
		for (int i = 0; i < 25; i++) {
			String fileName = "src/img/fire" + (i + 1) + ".png";
			ImageIcon icon = new ImageIcon(fileName);
			if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
				System.out.println("Loaded: " + fileName);
			} else {
				System.out.println("Failed to load: " + fileName);
			}
			fireSprites[i] = icon.getImage();
		}
		String fireCountStr = JOptionPane.showInputDialog("Nhập số lượng ngọn lửa từ 1 đến 10:");
		if (fireCountStr == null) {
			System.exit(0); // User clicked "Cancel" or closed the dialog, exit the program
		}

		int fireCount;
		try {
			fireCount = Integer.parseInt(fireCountStr);
			if (fireCount < 1 || fireCount > 10) {
				JOptionPane.showMessageDialog(null,
						"Số lượng ngọn lửa phải từ 1 đến 10. Chương trình sẽ đặt mặc định là 1.");
				fireCount = 1;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Đã nhập một giá trị không hợp lệ. Chương trình sẽ đặt mặc định là 1.");
			fireCount = 1;
		}

		Bai15 fireDisplay = new Bai15(fireCount, fireSprites);
		fireDisplay.firePanel.initFires(fireCount);
		fireDisplay.setVisible(true);
	}
}