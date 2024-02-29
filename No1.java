import java.awt.*;
import java.awt.geom.*;

public class No1 extends Frame {

    No1() {
        addWindowListener(new CloseWindow());
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        GeneralPath gp = new GeneralPath();

        gp.moveTo(100,100);
        gp.lineTo(100,170);
        gp.curveTo(100,180, 100, 180, 110, 180);
        gp.lineTo(280,180);
        gp.curveTo(290,180, 290, 180, 290, 170);
        gp.lineTo(290,100);
        gp.curveTo(290,90, 290, 90, 280, 90);
        gp.lineTo(110,90);
        gp.curveTo(100,90, 100, 90, 100, 100);

        g2d.draw(gp);

        g2d.setStroke(new BasicStroke(1.0f));

        new DrawSimpleCoordinateSystem(500, 500, g2d);
    }
    public static void main(String[] args) {
        No1 x = new No1();
        x.setTitle("Soal No 1 nih BOZZ");
        x.setSize(500, 500);
        x.setVisible(true);

    }
}