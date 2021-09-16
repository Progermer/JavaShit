package Assignments;
/**
 * Circle
 * @author <<Tomas Sutavicius>>
 * @ID <<1704915>>
 */

import java.util.Scanner;

class Circle {
    Scanner sc = new Scanner(System.in);

    public void run() {
        float xCord1; //Initialise variables to floats
        float xCord2;
        float xCordPoint;
        float yCord1;
        float yCord2; 
        float yCordPoint; 
        float radius1;
        float radius2;

        try { //In case someone decides to input a non real number, eg. char or string
            //System.out.println("Enter X coordinate of first circle: "); 
            xCord1 = sc.nextFloat();
            //System.out.println("Enter Y coordinate of first circle: ");
            yCord1 = sc.nextFloat();
            //System.out.println("Enter Radius coordinate of first circle: ");
            radius1 = sc.nextFloat();

            //System.out.println("Enter X coordinate of second circle: ");
            xCord2 = sc.nextFloat();
            //System.out.println("Enter Y coordinate of second circle: ");
            yCord2 = sc.nextFloat();
            //System.out.println("Enter Radius coordinate of second circle: ");
            radius2 = sc.nextFloat();
            
            //System.out.println("Enter X coordinate of point: ");
            xCordPoint = sc.nextFloat();
            //System.out.println("Enter Y coordinate of point: ");
            yCordPoint = sc.nextFloat();

            
            if ((radius1 >= 0) && (radius2 >= 0)) { //Checks if radius is valid
                if ((Math.pow(xCordPoint-xCord1, 2) + Math.pow(yCordPoint-yCord1, 2)) <= Math.pow(radius1, 2)) { // Checks if point lies in the first circle
                    if ((Math.pow(xCordPoint-xCord2, 2) + Math.pow(yCordPoint-yCord2, 2)) <= Math.pow(radius2,2)) { // Checks if point lies in the second circle
                        System.out.println("The point lies in both circles"); // if true to both conditions, prints that its in both
                    } else {
                        System.out.println("The point lies in the first circle"); // if second condition isn't true, then the point is only in the first circle
                    }
                } else if ((Math.pow(xCordPoint-xCord2, 2) + Math.pow(yCordPoint-yCord2, 2)) <= Math.pow(radius2,2)) { //Dont really now how to differentiate between no circles and second circle 
                    System.out.println("The point lies in the second circle"); //when using nested if so I made an else statement that checks the second circle condition again
                    } else {
                        System.out.println("The point does not lie in either circle");
                    }
            } else {
                System.out.println("input error"); //If radius is invalid, prints error
            }
    
        } catch (Exception e) {
            System.out.println("input error"); //If inputs from keyboard are invalid, this exception prints error and stops the program
        }
    }

    public static void main(String[] args) {
        (new Circle()).run();
    }
}
