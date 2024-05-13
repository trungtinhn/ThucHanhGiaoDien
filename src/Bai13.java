
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class Bai13 extends JFrame {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private ArrayList<Color> shapeColors = new ArrayList<>();
    private Color currentColor = Color.BLACK;
    private Shape currentShape = null;
    private int currentBrushSize = 1;
    private boolean fillShape = false;
    private boolean drawMode = true; // true: draw shapes, false: draw lines

    public Bai13() {
        setTitle("Simple Paint App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel controlPanel = new JPanel();
        JButton colorButton = new JButton("Chọn màu");
        JButton brushButton = new JButton("Chọn bút");
        JButton shapeButton = new JButton("Chọn hình");
        JButton lineButton = new JButton("Vẽ đường");

        colorButton.addActionListener(e -> {
            currentColor = JColorChooser.showDialog(null, "Chọn màu", currentColor);
        });

        brushButton.addActionListener(e -> {
            String size = JOptionPane.showInputDialog(null, "Nhập kích thước bút:", currentBrushSize);
            try {
                currentBrushSize = Integer.parseInt(size);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên hợp lệ.");
            }
        });

        shapeButton.addActionListener(e -> {
            fillShape = JOptionPane.showConfirmDialog(null, "Bạn muốn fill hình không?", "Fill",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            drawMode = true;
        });

        lineButton.addActionListener(e -> {
            drawMode = false;
        });

        controlPanel.add(colorButton);
        controlPanel.add(brushButton);
        controlPanel.add(shapeButton);
        controlPanel.add(lineButton);

        getContentPane().add(controlPanel, BorderLayout.NORTH);

        DrawingPanel drawingPanel = new DrawingPanel();
        getContentPane().add(drawingPanel, BorderLayout.CENTER);
    }

    private class DrawingPanel extends JPanel {
        private Point startPoint;

        public DrawingPanel() {
            setBackground(Color.WHITE);

            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    startPoint = e.getPoint();
                    if (drawMode) {
                        currentShape = null;
                    } else {
                        currentShape = new Path2D.Double();
                        ((Path2D) currentShape).moveTo(startPoint.getX(), startPoint.getY());
                    }
                    repaint();
                }

                public void mouseReleased(MouseEvent e) {
                    Point endPoint = e.getPoint();
                    if (drawMode) {
                        currentShape = createShape(startPoint, endPoint);
                        shapes.add(currentShape);
                        shapeColors.add(currentColor);
                    } else {
                        ((Path2D) currentShape).lineTo(endPoint.getX(), endPoint.getY());
                    }
                    repaint();
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    if (!drawMode)
                        return;
                    Point endPoint = e.getPoint();
                    currentShape = createShape(startPoint, endPoint);
                    repaint();
                }
            });
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            for (int i = 0; i < shapes.size(); i++) {
                g2d.setColor(shapeColors.get(i));
                g2d.draw(shapes.get(i));
                if (fillShape) {
                    g2d.fill(shapes.get(i));
                }
            }

            if (currentShape != null) {
                g2d.setColor(currentColor);
                g2d.draw(currentShape);
                if (fillShape && drawMode) {
                    g2d.fill(currentShape);
                }
            }
        }

        private Shape createShape(Point start, Point end) {
            if (start != null && end != null) {
                int x = Math.min(start.x, end.x);
                int y = Math.min(start.y, end.y);
                int width = Math.abs(start.x - end.x);
                int height = Math.abs(start.y - end.y);

                if (drawMode) {
                    return new Rectangle(x, y, width, height);
                } else {
                    Path2D path = new Path2D.Double();
                    path.moveTo(start.getX(), start.getY());
                    path.lineTo(end.getX(), end.getY());
                    return path;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Bai13 app = new Bai13();
            app.setVisible(true);
        });
    }
}
