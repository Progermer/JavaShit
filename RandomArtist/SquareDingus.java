package RandomArtist;

import java.awt.Graphics;

class SquareDingus extends Dingus {
    protected int sideLength;
    protected boolean filled; //true: filled, false: outline

    public SquareDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the CircleDingus properties, i.e., radius and filledness
        sideLength = random.nextInt(maxX);
        filled = random.nextBoolean();
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        if (filled)
            g.fillRect(x, y, sideLength, sideLength);
        else
            g.drawRect(x, y, sideLength, sideLength);
    }
}
