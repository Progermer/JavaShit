package Set1;
import java.util.Scanner;
class CelsiusToFahrenheit {
    Scanner sc = new Scanner(System.in);

    public void run(){
        double fahren;
        double celsius;
        System.out.println("Input temp in fahrenheit: ");
        fahren = sc.nextDouble();
        celsius = ((fahren-32)/1.8000);
        System.out.println(celsius+"°C");
    }

    public static void main(String[] args) {
        (new CelsiusToFahrenheit()).run();
    }
    
}
