package RandomArtist;

/**
 * SaturnDingus -- part of HA RandomArtist
 * example of a very simple Dingus
 * @author huub
 */

import java.awt.Graphics;
import java.awt.Color;

class SaturnDingus extends Dingus {
    protected int radius;
    protected boolean filled; //true: filled, false: outline

    public SaturnDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the SaturnDingus properties, i.e., radius and filledness
        radius = random.nextInt(maxX/16) + 10;
        filled = random.nextBoolean();
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillArc(x, y, radius, radius,0, 360);
        g.setColor(Color.YELLOW);
        g.drawOval(x-radius*1/2, y+radius*1/2, radius*2, radius/4);
        g.setColor(color);
        g.drawLine(x, y+radius*1/2, x+radius, y+radius*1/2);
        g.drawLine(x, y+radius*1/2 + 1, x+radius, y+radius*1/2 + 1);
        g.drawLine(x, y+radius*1/2 - 1, x+radius, y+radius*1/2 - 1);
        
        
    }
}