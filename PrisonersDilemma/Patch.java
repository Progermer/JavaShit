package PrisonersDilemma;

/**
 * INCOMPLETE 
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part Patch
 * 
 * @author Tomas Sutavicius 1704915
 * @author Gabrielius Rosinas 1655175
 * assignment group 68
 * 
 * assignment copyright Kees Huizing
 */

import java.util.ArrayList;

class Patch {
    //...
    private int rowCord, columnCord;
    private boolean IsC = false;
    private double currentScore = 0;
    private double nextScore = 0;
    private ArrayList<Patch> neighbours = new ArrayList<>();
    
    public Patch(boolean IsC, int row, int column){
        this.setCooperating(IsC);
        this.rowCord = row; this.columnCord = column;
    }
   



    void initNeighbours(ArrayList<Patch> Neighbours){
        this.neighbours = Neighbours;

    }
    // returns true if and only if patch is cooperating
    boolean isCooperating() {
        return this.IsC;
    }
    
    // set strategy to C if isCooperating is true and to D if false
    void setCooperating(boolean isC) {
        this.IsC = isC;
    }
    
    // change strategy from C to D and vice versa
    void toggleStrategy() {
        this.IsC = !(this.IsC);
    }
    
    // return currentScore of this patch in current round
    double getcurrentScore(double alpha) {






















        return 0.0;
        // if (this.isCooperating()){
        //     currentScore = -1; // because this loop also looks at this patch itself as a neighbour;
        //     for (int i=x-1; i<= x+1; i++){
        //         for (int j=y-1; j<= y+1; j++){
        //             if (grid[x][y].isCooperating()){ //get grid method
        //                 currentScore += 1;
        //             }
        //         }
        //     }
        // } else {
        //     for (int i=x-1; i<= x+1; i++){
        //         for (int j=y-1; j<= y+1; j++){
        //             if (grid[x][y].isCooperating()){
        //                 currentScore += 1;
        //             }
                    
        //         }
        //     }
        // }
        
        // //...
        // return 0.0; // CHANGE THIS
    }
}
