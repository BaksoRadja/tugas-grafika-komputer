import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class No5 extends JPanel implements Runnable {

    private final int width = 400;
    private final int height = 200;
    private final int padding = 20;
    private final int graphWidth = width - 2 * padding;
    private final int graphHeight = height - 2 * padding;
    private final int delay = 5; // Delay between frames in milliseconds

    private int[] yValues; // Array to store y-coordinates of the line
    private int index = 0; // Index to track position in the yValues array

    public No5() {
        super();
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocusInWindow();

        // Initialize yValues array with a basic heartbeat shape
        yValues = new int[graphWidth];
        for (int i = 0; i < graphWidth / 2; i++) {
            yValues[i] = graphHeight / 2 - (int) (Math.sin(Math.PI * 2 * i / (graphWidth / 2)) * graphHeight / 4);
        }
        for (int i = graphWidth / 2; i < graphWidth; i++) {
            yValues[i] = graphHeight / 2 + (int) (Math.sin(Math.PI * 2 * i / (graphWidth / 2)) * graphHeight / 4);
        }

        // Start the animation thread
        new Thread(this).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw axes
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(padding, padding, padding, height - padding);
        g2.drawLine(padding, height - padding, width - padding, height - padding);

        // Draw the line
        g2.setColor(Color.GREEN);
        g2.setStroke(new BasicStroke(3));
        for (int i = 1; i < graphWidth; i++) {
            g2.drawLine(padding + i - 1, height - padding - yValues[i - 1], padding + i, height - padding - yValues[i]);
        }
    }

    @Override
    public void run() {
        while (true) {
            // Update yValues array to simulate heartbeat movement
            yValues[index] = (yValues[index] + 10) % graphHeight;
            index = (index + 1) % graphWidth;

            // Repaint the panel to update the animation
            repaint();

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Heartbeat Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new No5());
        frame.pack();
        frame.setVisible(true);
    }
}
