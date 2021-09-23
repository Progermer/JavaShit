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
    String x = sc.next(); // type of automaton
    int L = sc.nextInt(); // length of row, doesnt count extra border cells
    int G = sc.nextInt(); // number of generations
    boolean[] tempGeneration = new boolean[L+2];
    boolean[] currentGeneration = new boolean[L+2];


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
            default:
                return false;
        }
    }

    void runB(){

    }

    void runU(){

    }

    void draw(boolean[] generation) { // prints current generation
        for (int i = 1; i < L + 2; i++ ){
            if (currentGeneration[i] == true){
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println("");
    }

    boolean[] nextGenerationA(boolean[] generation){ //returns next generation (hypothetically) // inputs an array, returns an array
    
        for (int i = 1; i < L + 1; i++) {
            int left = (currentGeneration[i-1]) ? 1 : 0;
            int mid = (currentGeneration[i]) ? 1 : 0;
            int right = (currentGeneration[i+1]) ? 1 : 0;
            String pattern = String.valueOf(left) + String.valueOf(mid) + String.valueOf(right);
            tempGeneration[i] = runA(pattern);
        }
        //print current gen
        //calc next gen
        //assign next gen to current gen variable
        //repeat
        //...
        //profit
        return tempGeneration;
    }

    void main(){
        String start = sc.next();
        if (start.equals("init_start")) {
            String input = sc.next();
            while (!(input.equals("init_end"))) {
                int n = Integer.parseInt(input);
                if( n <= L) {
                    currentGeneration[n+1] = true;
                } 
                input = sc.next();
            }
        }
        //draw(currentGeneration);
        for (int i = 0; i<G; i++){
            draw(currentGeneration);
            currentGeneration = nextGenerationA(currentGeneration);
                
            
            
        }
        

    }

        
    public static void main(String[] args) {
        (new Cellulitis()).main();
    }
}
