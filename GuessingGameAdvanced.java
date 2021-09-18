
/**
 * GuessingGameAdvanced -- second part of assignment 2 in 2ip90
 * @author <<Tomas Sutavicius>>
 * @id     <<1704915>>
 * @author <<Gabrielius Rosinas>>
 * @id     <<1655175>>
 * @date   <<16/09/2021>>
 */

import java.util.Scanner;
import java.util.Random;

class GuessingGameAdvanced {
    Scanner scanner = new Scanner(System.in);

    void run() {
        // TODO: Implementation
        String adjustBoundary; // PLAYER INPURS HIGHER/H OR LOWER/L
        int counter = 0; // GUESS COUNTER 
        boolean correct = false; // KEEPS TRACK IF PLAYER GUESSED CORRECTLY
        Random randomGenerator = new Random();
        int number = randomGenerator.nextInt(1000); // PROGRAMS INITIAL GUESS
        int limit[];
        limit = new int[2]; // LOWER AND UPER BOUNDS OF POSSIBLE GUESSES FOR COMPUTER
        limit[1] = 1000; // INITIAL UPPER BOUND
        limit[0] = 0; // INITIAL LOWER BOUND

        System.out.println(
            "Think of a secret number not smaller than 0 and not greater than 1000. Type ’go’ when you have one.");
        if (scanner.next().equals("go")) {
            while (!(correct) && (counter < 10)) { // THE GAME ITSELF
                System.out.println(number);
                adjustBoundary = scanner.next();
                if (adjustBoundary.contains("l")) {// IF YOUR NUMBER IS LOWER THAN PROGRAMS GUESS
                    limit[1] = number - 1; // SETS NEW UPPER BOUND
                    number = randomGenerator.nextInt(limit[1] - limit[0] + 1) + limit[0]; // NEW RANDOM GUESS BASED ON
                                                                                          // NEW BOUNDS
                } else if (adjustBoundary.contains("h")) {// IF YOUR NUMBER IS HIGHER THAN PROGRAMS GUESS
                    limit[0] = number + 1; // SETS NEW LOWER BOUND
                    number = randomGenerator.nextInt(limit[1] - limit[0] + 1) + limit[0];
                } else if (adjustBoundary.equals("Good guess! You won.")) {
                    correct = true;
                }
                counter = counter + 1; // GUESS COUNT
                if (counter == 10) {
                    System.out.println(number);
                    System.out.println("I give up. This should not happen!");
                }
            }
        }
    }

    public static void main(String[] args) {
        (new GuessingGameAdvanced()).run();
    }
}