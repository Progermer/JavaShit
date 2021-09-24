package Set5;
import java.util.Scanner;

public class StarryNight {
    Scanner sc = new Scanner(System.in);
    void printStars(int n){
        for (int i=1; i<n+1; i++){
            System.out.print("*");
        }
    }

    void nl(){
        System.out.println();
    }

    void printSpaces(int n){
        System.out.print(" ");
    }

    void write(){
        int n = sc.nextInt();
        for (int i=1; i<n+1; i++){
            printStars(i);
        }

    }


    public static void main(String[] args) {
        (new StarryNight()).write();
    }
    
}
