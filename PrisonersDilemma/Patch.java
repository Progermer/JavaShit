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

class Patch {
    //...
    
    boolean IsC = false;
    double currentScore = 0;
    double nextScore = 0;
    int x,y;

    
    // returns true if and only if patch is cooperating
    boolean isCooperating() {
        //...
        return false; // CHANGE THIS
    }
    
    // set strategy to C if isCooperating is true and to D if false
    void setCooperating(boolean isC) {
        //...
    }
    
    // change strategy from C to D and vice versa
    void toggleStrategy() {
        // ...
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
