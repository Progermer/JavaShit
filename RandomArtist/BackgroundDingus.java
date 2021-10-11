package RandomArtist;
import java.awt.Color;
import java.awt.Graphics;

// by <<Gabrielius Rosinas 1655175>>
// and <<Tomas Sutavicius 1704915>>
// as group <<68>>

class BackgroundDingus extends Dingus {
    protected int width;
    protected int length;

    public BackgroundDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the CircleDingus properties, i.e., radius and filledness
        width = maxX;
        length = maxY;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, length);
 
    }
}
