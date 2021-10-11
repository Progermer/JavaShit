package RandomArtist;
import java.awt.Graphics;
import java.awt.Color;

// by <<Gabrielius Rosinas 1655175>>
// and <<Tomas Sutavicius 1704915>>
// as group <<68>>

class UFODingus extends Dingus {
    protected int width;
    protected int height;
    protected Color window = new Color(176,176,176);
    

    public UFODingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        width = random.nextInt(30)+30;
        height = width/7;
        // initialize randomly the CircleDingus properties, i.e., radius and filledness
    
    }
    @Override
    void draw(Graphics g) {
        g.setColor(window);
        g.fillArc(x + width/4, y, width/2, height, 0, 180);
        g.setColor(color);
        g.fillArc(x, y-height/2, width, height*2, 180, 180);

        
    
        
    }
}
