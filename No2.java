import java.awt.*;
import java.awt.event.*;

public class No2 extends Frame implements Runnable {

    private final int width = 500;
    private final int height = 500;
    private final int sunRadius = 50;
    private final int planetRadius = 20;
    private double angle = 0;
    private final Color sunColor = Color.RED;
    private final Color planetColor = Color.GREEN;

    public No2() {
        setTitle("Planet Berputar2 mengelilingi Matahari :)");
        setSize(width, height);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        new Thread(this).start(); // Start the animation thread
    }

    @Override
    public void run() {
        while (true) {
            repaint(); // Trigger a repaint to update the graphics
            try {
                Thread.sleep(50); // Update every 20 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            angle += 0.1; // Update the angle for the planet's position
            if (angle >= 2 * Math.PI) {
                angle = 0; // Reset the angle after a full circle
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Draw the sun
        g.setColor(sunColor);
        g.fillOval(width / 2 - sunRadius, height / 2 - sunRadius, 2 * sunRadius, 2 * sunRadius);

        // Calculate the planet's coordinates based on angle
        int planetX = (int) (width / 2 + Math.cos(angle) * (width / 2 - sunRadius - planetRadius));
        int planetY = (int) (height / 2 + Math.sin(angle) * (height / 2 - sunRadius - planetRadius));

        // Draw the planet
        g.setColor(planetColor);
        g.fillOval(planetX, planetY, 2 * planetRadius, 2 * planetRadius);

    }

    public static void main(String[] args) {
        new No2();
    }
}
