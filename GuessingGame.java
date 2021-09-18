/**
 * GuessingGame
 * @author <<Tomas Sutavicius>>
 * @id <<1704915>>
 * @author <<Gabrielius Rosinas>>
 * @id <<1655175>>
 * @date <<16/09/2021>>
 */

import java.util.*; // for Scanner and Random

class GuessingGame {
    Scanner scanner = new Scanner(System.in);
    Random randomGenerator;

    void run() {
        // TODO: Implementation 
        String choice; // PLAYER'S CHOICE (YES // NO)
        int number = 0; // SECRET NUMBER TO BE GUESSED
        long seed; // SEED FOR RANDOM NUM GENERATION
        int guess; // GUESS OF THE PLAYER
        int counter = 0; // AMOUNT OF GUESSES
        boolean correct = false; // KEEPS TRACK IF PLAYER GUESSED CORRECTLY
        boolean hasItDied = false;// DETERMINES IF THE CODE SHOULD KEEP RUNNING
        String[][] historyTable;
        historyTable = new String[7][100]; // 2D ARRAY OF GUESSING HISTORY
       

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
            hasItDied = true;
        }
        
        for (int i=0; i<7; i++){ // INITIALIZES 2D ARRAY WITH DOTS
            for(int j=0; j<100; j++){
                historyTable[i][j] = (".");
            }
        }

        while (!(correct) && (counter < 7) && !(hasItDied)) { // THE GAME ITSELF
            guess = scanner.nextInt();
            if(guess > number) { // CONDITIONALS FOR GUESSES THAT ARE HIGHER/LOWER/CORRECT
                System.out.println("lower");
            } else if(guess < number){
                System.out.println("higher");
            } else if(guess == number){
                System.out.println("Good guess! You won.");
                correct = true;
            }
            historyTable[counter][number] = "|"; // CORRECT NUMBER POSITION IN 2D ARRAY
            historyTable[counter][guess] = "X"; // GUESS POSITION IN 2D ARRAY
            counter = counter + 1; // GUESS COUNT
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
