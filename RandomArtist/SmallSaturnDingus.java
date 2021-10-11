package RandomArtist;
import java.awt.Graphics;
import java.awt.Color;

// by <<Gabrielius Rosinas 1655175>>
// and <<Tomas Sutavicius 1704915>>
// as group <<68>>

// SmallSaturnDingus -- part of HA RandomArtist
// example of a very simple Dingus
// @author huub
 
class SmallSaturnDingus extends Dingus {
    protected int radius;
    protected boolean filled; //true: filled, false: outline

    public SmallSaturnDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the SmallSaturnDingus properties, i.e., radius and filledness
        radius = random.nextInt(maxX/40) + 10;
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