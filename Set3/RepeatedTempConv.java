package Set3;
import java.util.Scanner;
public class RepeatedTempConv {
    Scanner sc = new Scanner(System.in);
    
    public void run(){
        System.out.print("Celsius or Fahrenheit, that is the question: ");
        while (sc.hasNextDouble()){
            double temp = sc.nextDouble();
            String choice = sc.next();
            if ((choice.equals("c")) || (choice.equals("C"))){
                System.out.println(temp+" degrees Celsius is "+ (temp*1.8+32)+" Fahrenheit");
            } else if ((choice.equals("f")) || (choice.equals("F"))){
                System.out.println(temp+" degrees Fahrenheit is "+ (temp*1.8+32)+" Celsius");
            } else{
                break;
            }
            System.out.print("Celsius or Fahrenheit, that is the question: ");
        }
    }   




    public static void main(String[] args){
        (new RepeatedTempConv()).run();
    }
}

