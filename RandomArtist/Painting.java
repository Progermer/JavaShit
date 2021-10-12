package RandomArtist;

/*
 * part of HA Random artist
 * TO BE COMPLETED
 *
 * @author huub
 * @author kees
 */
// by <<Gabrielius Rosinas 1655175>>
// and <<Tomas Sutavicius 1704915>>
// as group <<68>>


import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.io.*;

public class Painting extends JPanel implements ActionListener {

   /*---- Randomness ----*/
    /** you can change the variable SEED if you like
     *  the same program with the same SEED will generate exactly the same sequence of pictures
     */
    final static long SEED = 37; // seed for the random number generator; any number works

    /** do not change the following two lines **/
    final static Random random = new Random( SEED ); // random generator to be used by all classes
    int randomNum = random.nextInt(30) + 10; // minimum number of shapes 10, maximum number = 40
    int numberOfRegenerates = 0;
    int[] shapeVal;


   /*---- Screenshots ----
    * do not change
    */
    char current = '0';
    String filename = "randomshot_"; // prefix
    
   /*---- Dinguses ----*/
    ArrayList<Dingus> shapes = new ArrayList<>();
    ArrayList<Dingus> stars = new ArrayList<>();
    
    public Painting() {
        setPreferredSize(new Dimension(800, 450)); // make panel 800 by 450 pixels.
        //setSize(new Dimension(800, 450)); // make panel 800 by 450 pixels.
        //...
    }

    @Override
    protected void paintComponent(Graphics g) { // draw all your shapes
        super.paintComponent(g);     // clears the panel
        // draw all shapes
        //background is printed first
        Dingus bg = new BackgroundDingus(800,450);
        bg.draw(g);
        //stars and small planets will be in the background of other shapes so printed first, random numb,
        //but many more than other shapes
        for (int s = 0; s < randomNum * 10; s++) {
            stars.get(s).draw(g);
        }
        for (int i = 0; i < randomNum; i++){
            Dingus shape = shapes.get(random.nextInt(shapes.size()));
            shape.draw(g);
        }
    }

    // reaction to button press
    @Override
    public void actionPerformed(ActionEvent e) {
        if ( "Regenerate".equals(e.getActionCommand()) ) {
            regenerate();
            repaint();
        } else { // screenshot
            saveScreenshot( this, filename+current++ ); // ++ to show of compact code :-)
        }
    }

    void regenerate() {
        numberOfRegenerates++; // do not change
        shapes.clear(); // clear the shapes list
        stars.clear();

        // create random shapes
        for (int i = 0; i < 25; i++){
            Dingus UFOD = new UFODingus(800, 450);
            shapes.add(UFOD);
            Dingus SaturnD = new SaturnDingus(800, 450);
            shapes.add(SaturnD);
            Dingus stupidDumbPlanet = new CirclePlanetDingus(800,450);
            shapes.add(stupidDumbPlanet);
            Dingus amogus = new Amingus(800, 450);
            shapes.add(amogus);
            if (i % 2 == 0) {
                Dingus satellite = new SatelliteDingus(800, 450);
                shapes.add(satellite);
            } 
        }
        // stars will always be present, so 400 * 2 + 100 stars and 40 planets will be created
        for (int i = 0; i < 400; i++) {
            if (i % 4 == 0) {
                Dingus star = new StarDingus(800,450);
                stars.add(star);
            } 
            if (i % 10 == 0) {
                Dingus smallPlanet = new SmallSaturnDingus(800,450);
                stars.add(smallPlanet);
            }
            Dingus smallStar1 = new SmallStarDingus(800,450);
            stars.add(smallStar1);
            Dingus smallStar2 = new SmallStarDingus(800,450);
            stars.add(smallStar2);
        }
    }
    /** 
     * saves a screenshot of a Component on disk
     *  overides existing files
     *
     * @param component - Component to be saved
     * @param name - filename of the screenshot, followed by a sequence number
     * 
     * do not change
     */
    void saveScreenshot(Component component, String name) {
        String randomInfo = ""+SEED+"+"+ (numberOfRegenerates-1); //minus 1 because the initial picture should not count
        System.out.println( SwingUtilities.isEventDispatchThread() );
        BufferedImage image =
            new BufferedImage(
                              component.getWidth(),
                              component.getHeight(),
                              BufferedImage.TYPE_INT_RGB
                             );
        // call the Component's paint method, using
        // the Graphics object of the image.
        Graphics graphics = image.getGraphics();
        component.paint( graphics ); // alternately use .printAll(..)
        graphics.drawString(randomInfo, 0, component.getHeight());
        
        try {
            ImageIO.write(image, "PNG", new File(name+".png"));
            System.out.println( "Saved screenshot as "+ name );
        } catch( IOException e ) {
            System.out.println( "Saving screenshot failed: "+e );
        }
    }
    
}