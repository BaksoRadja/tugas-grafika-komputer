import java.awt.*;
public class DrawSimpleCoordinateSystem {

    public DrawSimpleCoordinateSystem (int xmax, int ymax, Graphics2D g2d){

        int xOffset = 30;
        int yOffset = 50;
        int step = 20;
        String s;

        Font fo = g2d.getFont();

        g2d.setFont(new Font("sansserif",Font.BOLD, 9));

        g2d.drawLine(xOffset, yOffset, xmax, yOffset);

        for (int i = xOffset + step; i <= xmax; i = i + step){
            g2d.drawLine(i,yOffset - 2, i,yOffset + 2);
            g2d.drawString(String.valueOf(i), i - 7, yOffset - 7);

        }

        g2d.drawLine(xOffset, yOffset,xOffset,ymax);

        s="  ";

        for (int i = yOffset + step; i <= ymax; i = i + step) {
            g2d.drawLine(xOffset - 2, i,xOffset + 2,i);
            if (i > 99){
                s = "";
            }
           g2d.drawString(s+String.valueOf(i),xOffset - 25,i + 5);
        }
        g2d.setFont(fo);

    }
}
