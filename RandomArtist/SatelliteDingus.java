package RandomArtist;

import java.awt.Graphics;
import java.awt.Color;


class SatelliteDingus extends Dingus{
    protected int width;
    protected int height;
    protected Color body = new Color(70, 70, 81);

    public SatelliteDingus(int maxX, int maxY) {
        super(maxX,maxY);
        width = random.nextInt(100)+10;
        height = (width*4)/5;

    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y+((1/4)*height), width, (1/4)*height);
        g.setColor(body);
        g.fillRect(x+(2/5)*width, y, width/5, (3/4)*height);
        //g.fillArc(x+(2/5)*width, y+(7/8)*height, width*(1/5), width*(1/5), 0, 180);

    }
}
