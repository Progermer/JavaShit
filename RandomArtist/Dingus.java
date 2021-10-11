package RandomArtist;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Dingus --  part of HA Random Artist
 * abstract class representing an arbitrary shape
 * @author huub
 */
abstract class Dingus {
    /** random generator to be used by all subclasses of Dingus 
     *  do not change
     */
    Random random = Painting.random;

    /** postion of the shape (upper left corner) **/
    protected int x, y;

    /** color used for drawing this shape **/
    protected Color color;

    /** maximal coordinates; drawing area is (0,0)- (maxX,maxY) **/
    int maxX, maxY;
    int maxRGB = 255;


    /**
     * initializes color and position to random values
     *
     * @param maxX, maxY - give maximum values for the position
     */    
    public Dingus(int maxX, int maxY) {
        this.maxX = maxX; this.maxY = maxY;
        // initialize to a random position
        x = random.nextInt(maxX);
        y = random.nextInt(maxY);
        //initializes to a random color, ok swag
        color = new Color(random.nextInt(maxRGB),random.nextInt(maxRGB),random.nextInt(maxRGB));
    }

    abstract void draw(Graphics g);
}
