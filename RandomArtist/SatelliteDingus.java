package RandomArtist;
import java.awt.Graphics;
import java.awt.Color;

// by <<Gabrielius Rosinas 1655175>>
// and <<Tomas Sutavicius 1704915>>
// as group <<68>>

class SatelliteDingus extends Dingus{
    protected int width;
    protected int height;
    protected Color body = new Color(70, 70, 81);

    public SatelliteDingus(int maxX, int maxY) {
        super(maxX,maxY);
        width = random.nextInt(20)+20;
        height = (width*4)/5;
    }

    @Override
    void draw(Graphics g) {
        //satellite created, constant color of body, colorful wings
        g.setColor(color);
        g.fillRect(x, y+(height/4), width, (height/4));
        g.setColor(body);
        g.fillRect(x+(2*width/5), y, width/5, (3*height/4));
        g.fillArc(x+(2*width/5), y+(3*height/4), width/5, width/5, 0, 180);
    }
}
