package RandomArtist;
import java.awt.Graphics;
import java.awt.Color;

// by <<Gabrielius Rosinas 1655175>>
// and <<Tomas Sutavicius 1704915>>
// as group <<68>>

public class SmallStarDingus extends Dingus {
    int rand = random.nextInt(4);
    

    public SmallStarDingus(int maxX, int maxY) {
        super(maxX, maxY);
    }
    @Override
    void draw(Graphics g) {
        //since ratio is very specific, small stars are created
        Color[] colors = new Color[4];
        colors[0] = new Color(255,255,224);
        colors[1] = new Color(255,255,204);
        colors[2] = new Color(0,0,0);
        colors[3] = new Color(176,224,230);
        g.setColor(Color.WHITE);
        g.fillPolygon(new int[] {x, x+10/4, x+20/4}, new int[] {y + 20/4, y, y + 20/4}, 3);
        g.fillPolygon(new int[] {x, x+10/4, x+20/4}, new int[] {y+7/4, y+27/4, y+7/4}, 3);
    }
}
