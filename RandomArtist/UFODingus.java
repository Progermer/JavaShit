package RandomArtist;

/**
 * CircleDingus -- part of HA RandomArtist
 * example of a very simple Dingus
 * @author huub
 */

import java.awt.Graphics;
import java.awt.Color;

class UFODingus extends Dingus {
    protected int width;
    protected int height;
    protected Color window = new Color(176,176,176);
    

    public UFODingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
<<<<<<< HEAD
        width = random.nextInt(30)+30;
=======
        width = random.nextInt(100);
>>>>>>> a46ee56cf775862b65f7ca3615d678437807647f
        height = width/7;
        // initialize randomly the CircleDingus properties, i.e., radius and filledness
    
    }
   // 176 - 255

    @Override
    void draw(Graphics g) {
        // g.setColor(color);
        // g.drawRect(x,y, width, height);
        g.setColor(window);
        g.fillArc(x + width/4, y, width/2, height, 0, 180);
        g.setColor(color);
        g.fillArc(x, y-height/2, width, height*2, 180, 180);

        
    
        
    }
}