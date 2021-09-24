import java.util.Scanner;

public class Cellulitis {
    Scanner sc = new Scanner(System.in);
    String type = sc.next(); // type of automaton
    int length = sc.nextInt(); // length of row, doesnt count extra border cells
    int gens = sc.nextInt(); // number of generations
    boolean[] currentGen = new boolean[length+2]; // init boolean array of length + 2 to account for borders
    //int[] rules = new int[8]; TODO remove
    boolean[] rulesBool = new boolean[8];


    void draw(boolean[] generation){ //prints current generation
        for (int i = 0; i < length + 2; i++ ){
            if (generation[i]){
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    boolean patternA(String z){ // pattern A
        switch(z){
            case ("111"):
                return false;
            case ("010"):
                return false;
            case ("000"):
                return false;
            default:
                return true;
        }
    }

    boolean patternB(String z){ // pattern B
        switch(z){
            case ("001"):
                return true;
            case ("010"):
                return true;
            case ("100"):
                return true;
            case ("110"):
                return true;
            default:
                return false;
        }
    }

    boolean patternU(String z) { // custom pattern U
        switch(z){
            case ("000"):
                return rulesBool[0];
            case ("001"):
                return rulesBool[1];
            case ("010"):
                return rulesBool[2];
            case ("011"):
                return rulesBool[3];
            case ("100"):
                return rulesBool[4];
            case ("101"):
                return rulesBool[5];
            case ("110"):
                return rulesBool[6];
            case ("111"):
                return rulesBool[7];
            default:
                return false;
        }


    }

    boolean[] calcNextGen(boolean[] curGen){ // calculates the next generation and returns it 
        boolean[] nextGen = new boolean[length+2]; // initializes/resets nextGen array
        for (int i = 1; i<length+1; i++){
            int left = (curGen[i-1]) ? 1 : 0;
            int mid = (curGen[i]) ? 1 : 0;
            int right = (curGen[i+1]) ? 1 : 0;
            String pattern = String.valueOf(left) + String.valueOf(mid) + String.valueOf(right); //creates cell neighbourhood pattern
            if (type.equals("A")){
                nextGen[i] = patternA(pattern);
            } else if (type.equals("B")) {
                nextGen[i] = patternB(pattern);
            } else if (type.equals("U")){
                nextGen[i] = patternU(pattern);
            }   
        }
        return nextGen;
    }

    void init(){ //initializes all inputs 
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
        if (type.equals("U")) { // initializes the rules for automaton type U
            for( int j = 0; j < 8; j++ ){
                //rules[j] = sc.nextInt();
                if (sc.nextInt() == 1){
                    rulesBool[j] = true;
                } else {
                    rulesBool[j] = false;
                }
            }
        }
    }

    void main(){
        init();
        for (int i = 0; i < gens; i++){
            draw(currentGen); // draws current generation
            currentGen = calcNextGen(currentGen); // equates current generation to the next generation  
        }
        
    }

    public static void main(String[] args) {
        (new Cellulitis()).main();
    }
}