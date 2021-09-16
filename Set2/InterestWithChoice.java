package Set2;
import java.util.Scanner;

class InterestWithChoice {
    Scanner sc = new Scanner(System.in);

    public void calc(){
        double balance;
        System.out.println("Input balance: ");
        balance = sc.nextDouble();

        if (balance >= 0) {
            if (balance >= 10000){
                balance = balance + (balance*0.03);
            } else {
                balance = balance + (balance*0.025);
            }
        } else {
            balance = balance - ((balance*-1)*0.005);
        }
        System.out.println("New balance after a year: " + balance);
    }

    public static void main(String[] args){
        (new InterestWithChoice()).calc();
    }


    
}
