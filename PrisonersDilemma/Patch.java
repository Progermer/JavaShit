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
    private boolean IsC = false;
    //private double nextScore = 0;
    private ArrayList<Patch> neighbours = new ArrayList<>();
    
    public Patch(boolean IsC){
        this.setCooperating(IsC);
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
        double currentScore = 0;
        for (Patch patch : neighbours){
            if (patch.isCooperating()){
                currentScore+=1;
            }
        }
        if (this.isCooperating()){
            return currentScore;
        } else {
            return currentScore*alpha;
        }
    }
}
