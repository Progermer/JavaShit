package Set1;
import java.util.Scanner;
class AgeFinder {
    Scanner sc = new Scanner(System.in);
    int DoB;
    int curD;
    int age;

    public void find(){
        System.out.println("enter date of birth: ");
        DoB = sc.nextInt();
        System.out.println("enter current date: ");
        curD = sc.nextInt();
        age = (curD-DoB)/10000;
        System.out.println(age);
    }
    public static void main(String[] args) {       
        (new AgeFinder()).find();
    } 
}