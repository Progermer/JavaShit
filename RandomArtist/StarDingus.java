package RandomArtist;
import java.awt.Graphics;
import java.awt.Color;

public class StarDingus extends Dingus {
    int rand = random.nextInt(4);
    
    

    public StarDingus(int maxX, int maxY) {
        super(maxX, maxY);
       
        // int x1 = x;
        // int x2 = x + 10;
        // int x3 = x + 20;
        // int y1 = y;
        // int y2 = y - 20;
        // int y3 = y -13;
        // int y4 = y -3;




    }
    @Override
    void draw(Graphics g) {
        Color[] colors = new Color[4];
        colors[0] = new Color(255,255,224);
        colors[1] = new Color(255,255,204);
        colors[2] = new Color(0,0,0);
        colors[3] = new Color(176,224,230);
        Color color = colors[rand];
        g.setColor(color);
        // g.fillPolygon(new int[] {x, x+10, x+20}, new int[] {y + 20, y, y + 20}, 3);
        // g.fillPolygon(new int[] {x, x+10, x+20}, new int[] {y+7, y+27, y+7}, 3);
        g.fillPolygon(new int[] {x, x+10/2, x+20/2}, new int[] {y + 20/2, y, y + 20/2}, 3);
        g.fillPolygon(new int[] {x, x+10/2, x+20/2}, new int[] {y+7/2, y+27/2, y+7/2}, 3);
        // g.fillPolygon(new int[] {x, x+10 /3, x+20 /3}, new int[] {y + 20 /3, y, y + 20 /3}, 3);
        // g.fillPolygon(new int[] {x, x+10 /3, x+20 /3}, new int[] {y+7 /3, y+27 /3, y+7 /4}, 3);
    }
}
