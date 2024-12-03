/*
Ella Harshyne
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TriangleCarpet extends Canvas {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Triangle Carpet");
        frame.setSize(900, 900);

        TriangleCarpet tp = new TriangleCarpet();
        frame.add(tp);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    public void paint(Graphics g) {
        int side = getSize().height;
        //this sets the big triangle to black
        g.setColor(Color.black);
        int [] x = new int[]{0, side/2, side};
        int [] y = new int[]{side, 0, side};
        g.fillPolygon(x, y, 3);
        //this sets every new triangle made to white
        g.setColor(Color.white);
        //this is where the draw carpet is called recursively
        drawCarpet(0, 0, side, g);

    }

    public void drawCarpet(int x, int y, int side, Graphics g) {

        int sub = side / 4;
        int[] xvals = new int[]{x+sub, x+sub*3, x+sub*2};
        int[] yvals = new int[]{y+sub*2, y+sub*2, y+side};

        g.fillPolygon(xvals, yvals, 3);
        //this repeats the process until the code is less than 4 pixels
        if (side >= 4) {

            //this is the code for the bottom left square
            drawCarpet(x, y+sub*2, sub*2, g);//left
            drawCarpet(x+sub, y, sub*2, g);//top
            drawCarpet(x+sub*2, y+sub*2, sub*2, g);//right

        }

    }

}
