import java.util.Scanner;

public class Cellulitis2 {
    Scanner sc = new Scanner(System.in);
    String[] pattern = new String[8];
    String x = sc.next(); // type of automaton
    int L = sc.nextInt(); // length of row, doesnt count extra border cells
    int G = sc.nextInt(); // number of generations
    boolean[] currentGen = new boolean[L+2];
    boolean[] nextGen = new boolean[L+2];

    void draw(){ //draws current generation
    
    }

    boolean A(index){ // pattern
        for (String i : pattern){
            if (i.equals(index)){
                if (i.equals("1")){
                    return true;
                } else{
                    return false;
                }
            }
        }
    }

    boolean[] calcNextGen(boolean[] gen){ // calculates the next generation and returns it 
        return gen;
    }

    void main(){
        String start = sc.next();
        if (start.equals("init_start")) {
            String input = sc.next();
            while (!(input.equals("init_end"))) {
                int n = Integer.parseInt(input);
                if( n < L) {
                    currentGeneration[n+1] = true;
                input = sc.next();
            }
        } 
    }




}



//TODO

// Draw
    // function that gets passed the current generation and draws it
    //
    //
