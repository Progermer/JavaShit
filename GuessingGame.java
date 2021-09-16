/**
 * GuessingGame
 * @author <<Tomas Sutavicius>>
 * @id <<1704915>>
 * @author <<Gabrielius Rosinas>>
 * @id <<1655175>>
 * @date 16/09/2021
 */

import java.util.*; // for Scanner and Random

class GuessingGame {
    Scanner scanner = new Scanner(System.in);
    Random randomGenerator;

    void run() {
        // TODO: Implementation 
        String choice;
        int number = 0; // "code"
        long seed;
        int guess;
        int counter = 0;
        boolean correct = false; 
        String[][] historyTable;
        historyTable = new String[7][100]; 
        boolean hasItDied = false;//TRUE IF WRONG INPUT INITIALLY

        System.out.println("Do you want to enter the secret code yourself ?"); // QUESTIONNAIRE TIME BABY
        choice = scanner.next();
        if(choice.equals("yes")){
            System.out.println("Secretly type the code");
            number = scanner.nextInt(); // TODO: has to be between 0 - 99
            System.out.println("Start Guessing!");
        } else if(choice.equals("no")) {
            System.out.println("Type an arbitrary number");
            seed = scanner.nextInt(); 
            Random randomGenerator = new Random(seed);
            number = randomGenerator.nextInt(100);
            System.out.println("Start Guessing!");
        } else {
            System.out.println("fuck off");
            hasItDied = true;
        }
        
        for (int i=0; i<7; i++){ // INITIALIZES TABLE WITH DOTS
            for(int j=0; j<100; j++){
                historyTable[i][j] = (".");
            }
        }

        while (!(correct) && (counter < 7) && !(hasItDied)) { // THE GAME ITSELF
            guess = scanner.nextInt();
            if(guess > number) {
                System.out.println("lower");
            } else if(guess < number){
                System.out.println("higher");
            } else if(guess == number){
                System.out.println("Good guess! You won.");
                correct = true;
            }
            historyTable[counter][number] = "|";
            historyTable[counter][guess] = "X";
            counter = counter + 1;
            if (counter == 7) {
                System.out.println("No more guesses, you lost.");
            }
        }
        
        if(!(hasItDied)) { // PRINTS OUT HISTORY TABLE
            System.out.println(counter + " guesses:");
            for (int i=0; i < counter; i++) {
                for (int j=0; j < historyTable[i].length; j++) {        
                    System.out.print( historyTable[i][j] );
                }    
            System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        (new GuessingGame()).run();
    }
}
