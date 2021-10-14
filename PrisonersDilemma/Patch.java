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
    float score = 0;


    
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
    
    // return score of this patch in current round
    double getScore() {
        //...
        return 0.0; // CHANGE THIS
    }
}
