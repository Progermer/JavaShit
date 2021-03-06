package RandomArtist;
import java.awt.Graphics;
import java.awt.Color;

// by <<Gabrielius Rosinas 1655175>>
// and <<Tomas Sutavicius 1704915>>
// as group <<68>>

class Amingus extends Dingus{
    protected int width;
    protected int height;
    protected Color glass = new Color(164, 204, 219); // Character's glass will always have the same color

    public Amingus(int maxX, int maxY) {
        super(maxX, maxY);
        height = random.nextInt(20)+10;
        width = height/2;
    }

    @Override
    void draw(Graphics g) {
        //Shape is created with specific ratios
        g.setColor(color);
        g.fillRoundRect(x, y, width, height, 5, 5);
        g.fillRoundRect(x + width, y + (height / 5), width / 3, (3 * height) / 5, 5, 5);
        g.setColor(Color.BLACK);
        g.fillRect(x + width / 3, y + (4 * height / 5), width / 3, height / 3 + 1);
        g.setColor(glass);
        g.fillOval(x - (width / 6), y + (height / 5), width, height / 3);
    }
}