/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.QuadCurve2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;

public class Bai14 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai14 frame = new Bai14();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bai14() {
		setTitle("BT14");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new BezierPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}
}

class BezierPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final int STEP = 1;
	public static final String NAME = "Nguyen Trung Tinh";
	private int t = 0;
	private QuadCurve2D curve = new QuadCurve2D.Float();
	private int pointIndex = 0;

	public BezierPanel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (pointIndex == 0) {
					curve.setCurve(e.getX(), e.getY(), getWidth() / 2, getHeight() / 2, getWidth() / 2,
							getHeight() / 2);
				} else if (pointIndex == 1) {
					curve.setCurve(curve.getX1(), curve.getY1(), e.getX(), e.getY(), curve.getX2(), curve.getY2());
				} else {
					curve.setCurve(curve.getX1(), curve.getY1(), curve.getCtrlX(), curve.getCtrlY(), e.getX(),
							e.getY());
				}
				pointIndex = (pointIndex + 1) % 3;
				repaint();
			}
		});

		Timer timer = new Timer(STEP, e -> {
			t += STEP;
			if (t > 100) {
				t = 0;
			}
			repaint();
		});
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.draw(curve);
		double tScaled = t / 100.0;
		double x = (1 - tScaled) * (1 - tScaled) * curve.getX1() + 2 * (1 - tScaled) * tScaled * curve.getCtrlX()
				+ tScaled * tScaled * curve.getX2();
		double y = (1 - tScaled) * (1 - tScaled) * curve.getY1() + 2 * (1 - tScaled) * tScaled * curve.getCtrlY()
				+ tScaled * tScaled * curve.getY2();
		g2d.drawString(NAME, (int) x, (int) y);
	}
}