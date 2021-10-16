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
    private int minRow = 1; private int minColumn = 1; 
    private int maxRow = 51; private int maxColumn = 51;

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
        for (int row = minRow; j <= maxRow; j++){
            for (int column = minColumn; i <= maxColumn; i++) {
                grid[row][column] = new Patch(random.nextBoolean(), row, column);
            }
        }
        for (int row = minRow; row <= maxRow; row++){
            for (int column = minColumn; column <= maxColumn; column++) {
                neighbours.add(grid[row-1][column-1]); // top left
                neighbours.add(grid[row-1][column]); // top
                neighbours.add(grid[row-1][column+1]); // top right
                neighbours.add(grid[row][column-1]); // left
                neighbours.add(grid[row][column+1]); // right
                neighbours.add(grid[row+1][column-1]); // bottom left
                neighbours.add(grid[row+1][column]); // bottom 
                neighbours.add(grid[row+1][column+1]); // bootom right
                grid[row][column].initNeighbours(neighbours);
                neighbours.clear();
            }
        }
    }

    public void setBorder(){
        grid[0][0] = grid[maxRow][maxColumn]; // top left border
        grid[maxRow+1][0] = grid[minRow][maxColumn]; // bottom left border
        grid[0][maxColumn+1] = grid[maxRow][minColumn]; // top right border
        grid[maxRow+1][maxColumn+1] = grid[minRow][minColumn]; // bottom right border
        for (int i = 1; i <= maxRow; i++){ 
            grid[i][0] = grid[i][maxColumn]; // copies right values to left border
            grid[i][maxColumn+1] = grid[i][minColumn]; // copies left values to right border
            grid[maxRow+1][i] = grid[minRow][i]; // copies top values to bottom border
            grid[0][i] = grid[maxRow][i]; // copies bottom values to top border
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

