package PrisonersDilemma;

/**
 * INCOMPLETE
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part PlayingField
 * 
 * @author FILL IN
 * @author FILL IN
 * assignment group FILL IN
 * 
 * assignment copyright Kees Huizing
 */

import javax.swing.Timer;
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


class PlayingField extends JPanel /* possible implements ... */ {

    public PlayingField(){
        setPreferredSize(new Dimension(800, 450));
    }
    

    private Patch[][] grid = new Patch[52][52]; // + 2 for borders
    private ArrayList<Patch> neighbours = new ArrayList<>();

    
    //initialize grid of objects
    private int minX = 1; private int minY = 1; 
    private int maxX = 51; private int maxY = 51;

    private double alpha; // defection award factor
    
    private Timer timer;
    
    // random number genrator
    private static final long SEED = 37L; // seed for random number generator; any number goes
    public static final Random random = new Random( SEED );         
    
    //...
    
    /**
     * calculate and execute one step in the simulation 
     */

    public void initGrid() {
        for (int j = minY; j <= maxY; j++){
            for (int i = minX; i <= maxX; i++) {
                grid[i][j] = new Patch(random.nextBoolean(), i, j);
            }
        }
        for (int j = minY; j <= maxY; j++){
            for (int i = minX; i <= maxX; i++) {
                neighbours.add(grid[j-1][i-1]); // top left
                neighbours.add(grid[j][i-1]); // top
                neighbours.add(grid[j+1][i-1]); // top right
                neighbours.add(grid[j-1][i]); // left
                neighbours.add(grid[j+1][i]); // right
                neighbours.add(grid[j-1][i+1]); // bottom left
                neighbours.add(grid[j][i+1]); // bottom 
                neighbours.add(grid[j+1][i+1]); // bootom right
                grid[i][j].initNeighbours(neighbours);
                neighbours.clear();
            }
        }
    }

    public void setBorder(){
        grid[0][0] = grid[maxX][maxY]; // top left border
        grid[maxX+1][0] = grid[minX][maxY]; // top right border
        grid[0][maxY+1] = grid[maxX][minY]; // bottom left border
        grid[maxX+1][maxY+1] = grid[minX][minY]; // bottom right border
        for (int i = 1; i <= maxX; i++){ // copies bottom values to top border
            grid[i][0] = grid[i][maxY];
        }
        for (int i = 1; i <= maxX; i++){ // copies top values to bottom border
            grid[i][maxY+1] = grid[1][minY];
        }
        for (int i = 1; i <= maxX; i++){ // copies left values to right border
            grid[maxX+1][i] = grid[minX][i];
        }
        for (int i = 1; i <= maxX; i++){ // copies right values to left border
            grid[0][i] = grid[maxX][i];
        }

    }
    public void step() {
        
    }
    
    public void setAlpha( double alpha ) {
        //...
    }
    
    public double getAlpha( ) {
        //...
        return 0.0; // CHANGE THIS
    }
    
    // probably just used for printing
    // return grid as 2D array of booleans
    // true for cooperators, false for defectors
    // precondition: grid is rectangular, has non-zero size and elements are non-null
    public boolean[][] getGrid() {
        boolean[][] resultGrid = new boolean[grid.length][grid[0].length];
        for (int x = 0; x < grid.length; x++ ) {
            for (int y = 0; y < grid[0].length; y++ ) {
                resultGrid[x][y] = grid[x][y].isCooperating();
            }
        }
        
        return resultGrid; 
    }
    
    // sets grid according to parameter inGrid
    // a patch should become cooperating if the corresponding
    // item in inGrid is true
    public void setGrid(boolean[][] inGrid) {
        // ...
    }   
}

