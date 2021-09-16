package Set2;
//author ...
//date ...
//interest calculation
 

import java.util.Scanner;

class Interest {
    Scanner sc = new Scanner(System.in);

    public void calcInterest() {
        double balance;
        double rate; // percentage
        double tax; // percentage
        System.out.println("Give initial balance");
        balance = sc.nextDouble();
        System.out.println("Give interest rate as percentage ");
        rate = sc.nextDouble();
        System.out.println("Give tax as a percentage ");
        tax = sc.nextDouble();
        balance = ((balance * rate / 100.0)+balance);

        System.out.print("After a year you get in total: " + balance + "\nTax: " + (balance*tax/100.0));
    }

    public static void main(String[] args) {
        (new Interest() ).calcInterest();
    }
}