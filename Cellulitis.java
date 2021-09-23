/**
 * Homework Assignment 3 2ip90
 *  
 * @author <<Tomas Sutavicius>>
 * @id <<1704915>>
 * @author <<Gabrielius Rosinas>>
 * @id <<1655175>>
 * @group <<68>>
 * @date <<16/09/2021>>
 */

import java.util.Scanner;

public class Cellulitis {
    Scanner sc = new Scanner(System.in);
    boolean[] tempGeneration;
    boolean[] currentGeneration;
    String x = sc.next(); // type of automaton
    int L = sc.nextInt(); // length of row, doesnt count extra border cells
    int G = sc.nextInt(); // number of generations
    currentGeneration = new boolean[L+2];
    tempGeneration = new boolean[L+2];
    


    boolean runA(String z){
        switch(z){
            case ("000"):
                return false;
            case ("001"):
                return true;
            case ("010"):
                return false;
            case ("011"):
                return true;
            case ("100"):
                return true;
            case ("101"):
                return true;
            case ("110"):
                return true;
            case ("111"):
                return false;
        }
        return runA(z);
    }

    void runB(){

    }

    void runU(){

    }

    void draw(){

    }

    boolean[] nextGenerationA(boolean[] generation){
        for (int i = 1; i < L + 2; i++ ){
            if (currentGeneration[i] == true){
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        for (int i = 1; i < L + 2; i++) {
            int left = (currentGeneration[i-1]) ? 1 : 0;
            int mid = (currentGeneration[i]) ? 1 : 0;
            int right = (currentGeneration[i+1]) ? 1 : 0;
            String pattern = String.valueOf(left) + String.valueOf(mid) + String.valueOf(right);
            boolean newVal = runA(pattern);
            int fick = (newVal)? 1 : 0;
            currentGeneration
        }
        //print current gen
        //calc next gen
        //assign next gen to current gen variable
        //repeat
        //...
        //profit
        return generation;
    }

    void main(){

    }

        
    public static void main(String[] args) {
        (new Cellulitis()).main();
    }
}
