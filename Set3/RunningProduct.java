package Set3;
import java.util.Scanner;

public class RunningProduct {
    Scanner sc = new Scanner(System.in);

    public void summation(){
        int sum = 1;
        int count = 0;
        while (sc.hasNextInt()){
            int number = sc.nextInt();
            if (number != 0){
                sum *= number;
                count+=1;
            } else {
                break;
            }
            
        }
        System.out.println("Product is " + sum + "\nNumbers entered: "+ count);

    }





    public static void main(String[] args){
        (new RunningProduct()).summation();
    }
} 
