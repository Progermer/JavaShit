package RandomArtist;
import java.awt.Graphics;
import java.awt.Color;

// by <<Gabrielius Rosinas 1655175>>
// and <<Tomas Sutavicius 1704915>>
// as group <<68>>

public class StarDingus extends Dingus {
    int rand = random.nextInt(4);
    
    public StarDingus(int maxX, int maxY) {
        super(maxX, maxY);
    }

    @Override
    void draw(Graphics g) {
        //Stars are made with 2 triangles
        Color[] colors = new Color[4];
        colors[0] = new Color(255,255,224);
        colors[1] = new Color(255,255,204);
        colors[2] = new Color(0,0,0);
        colors[3] = new Color(176,224,230);
        Color color = colors[rand];
        g.setColor(color);
        g.fillPolygon(new int[] {x, x+10/2, x+20/2}, new int[] {y + 20/2, y, y + 20/2}, 3);
        g.fillPolygon(new int[] {x, x+10/2, x+20/2}, new int[] {y+7/2, y+27/2, y+7/2}, 3);
    }
}
