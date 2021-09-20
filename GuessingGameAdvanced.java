
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
        int mid; // MIDPOINT BETWEEN UPPER AND LOWER BOUND
        int high = 1000; // INITIAL UPPER BOUND
        int low = 0; // INITIAL LOWER BOUND
        
        System.out.println(
            "Think of a secret number not smaller than 0 and not greater than 1000. Type ’go’ when you have one.");
        if (scanner.next().equals("go")) {
            while (!(correct) && (counter < 10)) {
                mid = ((high+low)/2); // Using Binary Search, midpoint rounded down, int div.
                System.out.println(mid);
                adjustBoundary = scanner.next();
                if (adjustBoundary.contains("l")) {
                    high = mid - 1; // Upper bound one less than number guessed
                } else if (adjustBoundary.contains("h")) {
                    low = mid + 1; // Lower bound one greater than number guessed
                } else if (adjustBoundary.contains("guessed")) {
                    correct = true; 
                }
                counter += 1;
            }
            // Should not be possible, binary search will find number within 10 guesses
            if (!(correct) && (counter == 10)){
                System.out.println("I give up");
            }
        }
   
    }
    public static void main(String[] args) {
        (new GuessingGameAdvanced()).run();
    }
}

         