import java.util.Scanner;
import java.util.Arrays;

public class Cellulitis2 {
    Scanner sc = new Scanner(System.in);
    String type = sc.next(); // type of automaton
    int length = sc.nextInt(); // length of row, doesnt count extra border cells
    int gens = sc.nextInt(); // number of generations
    boolean[] currentGen = new boolean[length+2];
    



    void draw(boolean[] generation){ //draws current generation
        for (int i = 0; i < length + 2; i++ ){
            if (generation[i]){
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    boolean patternA(String z){ // pattern
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

    boolean patternB(String z){
        switch(z){
            case ("000"):
                return false;
            case ("001"):
                return true;
            case ("010"):
                return true;
            case ("011"):
                return false;
            case ("100"):
                return true;
            case ("101"):
                return false;
            case ("110"):
                return true;
            case ("111"):
                return false;
            default:
                return false;
        }
    }

    boolean patternU()
    boolean[] calcNextGen(boolean[] curGen){ // calculates the next generation and returns it 
        boolean[] nextGen = new boolean[length+2];
        for (int i = 1; i<length+1; i++){
            int left = (curGen[i-1]) ? 1 : 0;
            int mid = (curGen[i]) ? 1 : 0;
            int right = (curGen[i+1]) ? 1 : 0;
            String pattern = String.valueOf(left) + String.valueOf(mid) + String.valueOf(right);
            if (type.equals("A")){
                nextGen[i] = patternA(pattern);
            } else if (type.equals("B")) {
                nextGen[i] = patternB(pattern);
            } else if (type.equals("U")) {

            }
            
        }
        return nextGen;
    }

    void init(){
        String start = sc.next();
        if (start.equals("init_start")) {
            String input = sc.next();
            while (!(input.equals("init_end"))) {
                int n = Integer.parseInt(input);
                if( n < length+1) {
                    currentGen[n] = true;
                }
                input = sc.next();
            }
        } 
    }

    void main(){
        init();
        for (int i = 0; i < gens; i++){
            draw(currentGen);
            currentGen = calcNextGen(currentGen);          
        }
        
    }

    public static void main(String[] args) {
        (new Cellulitis2()).main();
    }



}




// Draw
    // function that gets passed the current generation and draws it
    //
    //
