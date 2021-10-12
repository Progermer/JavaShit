package RandomArtist;
import java.awt.Graphics;
import java.awt.Color;

// by <<Gabrielius Rosinas 1655175>>
// and <<Tomas Sutavicius 1704915>>
// as group <<68>>

class CirclePlanetDingus extends Dingus {
    protected int radius;
    protected boolean filled; //true: filled, false: outline
    protected int rand = random.nextInt(4);
    protected int rand2 = random.nextInt(4);

    public CirclePlanetDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the CirclePlanetDingus properties, i.e., radius and filledness
        radius = random.nextInt(10) + 1;
        filled = random.nextBoolean();
    }

    @Override
    void draw(Graphics g) {
        // "random" colors are two sets of 4 colors which alternate with each circle
        Color[] colors1 = new Color[4];
        colors1[0] = new Color(252, 177, 237);
        colors1[1] = new Color(19, 161, 154);
        colors1[2] = new Color(51, 92, 43);
        colors1[3] = new Color(112, 105, 104);
        Color[] colors2 = new Color[4];
        colors2[0] = new Color(36, 5, 24);
        colors2[1] = new Color(59, 73, 161);
        colors2[2] = new Color(181, 177, 123);
        colors2[3] = new Color(0,0,0);
        g.setColor(colors1[rand]);
        g.fillArc(x, y, radius*4, radius*4,0, 360);
        g.setColor(colors2[rand2]);
        g.fillArc(x+radius / 3, y+radius / 3, radius*3, radius*3,0, 360);
        g.setColor(colors1[rand2]);
        g.fillArc(x + 2 * radius / 3, y + 2*radius /3 , radius*2, radius*2,0, 360);
        g.setColor(colors2[rand]);
        g.fillArc(x+radius, y+radius, radius, radius,0, 360);

       
        
        
    }
}