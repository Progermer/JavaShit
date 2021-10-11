package RandomArtist;

/**
 * CirclePlanetDingus -- part of HA RandomArtist
 * example of a very simple Dingus
 * @author huub
 */

import java.awt.Graphics;
import java.awt.Color;

class CirclePlanetDingus extends Dingus {
    protected int radius;
    protected boolean filled; //true: filled, false: outline
    int rand = random.nextInt(4);
    int rand2 = random.nextInt(4);



    public CirclePlanetDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the CirclePlanetDingus properties, i.e., radius and filledness
        radius = random.nextInt(10) + 1;
        filled = random.nextBoolean();
        Color[] colors1 = new Color[4];
        colors1[0] = new Color(252, 177, 237);
        colors1[1] = new Color(19, 161, 154);
        colors1[2] = new Color(51, 92, 43);
        colors1[3] = new Color(112, 105, 104);
        Color[] colors2 = new Color[4];

    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillArc(x, y, radius*4, radius*4,0, 360);
        g.setColor(color);
        g.fillArc(x+radius / 3, y+radius / 3, radius*3, radius*3,0, 360);
        g.setColor(color);
        g.fillArc(x + 2 * radius / 3, y + 2*radius /3 , radius*2, radius*2,0, 360);
         g.setColor(color);
        g.fillArc(x+radius, y+radius, radius, radius,0, 360);

       
        
        
    }
}