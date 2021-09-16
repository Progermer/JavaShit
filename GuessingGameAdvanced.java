
/**
 * GuessingGameAdvanced -- second part of assignment 2 in 2ip90
 * @author TODO
 * @id     TODO
 * @author TODO
 * @id     TODO
 * @date   TODO
 */

import java.util.Scanner;
import java.util.Random;

class GuessingGameAdvanced {
    Scanner scanner = new Scanner(System.in);

    void run() {
        // TODO: Implementation
        String adjustBoundary;
        int counter = 0;
        boolean correct = false;
        Random randomGenerator = new Random();
        int number = randomGenerator.nextInt(1001);
        int limit[];
        limit = new int[2]; // lower and upper bounds of possible guesses for computer
        limit[1] = 1001;
        limit[0] = 0;

        System.out.println(
                "Think of a secret number not smaller than 0 and not greater than 1000. Type ’go’ when you have one.");
        if (scanner.next().equals("go")) {
            while (!(correct) && (counter < 10)) { // THE GAME ITSELF
                System.out.println(number);
                adjustBoundary = scanner.next();
                if (adjustBoundary.contains("l")) {// if lower than your number
                    limit[1] = number - 1;
                    number = randomGenerator.nextInt(limit[1] - limit[0] + 1) + limit[0];// If random generates 0, lower
                                                                                         // bound will be added
                } else if (adjustBoundary.contains("h")) {//if higher than your nuber
                    limit[0] = number + 1;
                    number = randomGenerator.nextInt(limit[1] - limit[0] + 1) + limit[0];
                } else if (adjustBoundary.equals("cum")) {
                    correct = true;
                }
                counter = counter + 1;
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