package Set4;
import java.util.*;

class EchoPit {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> words = new ArrayList<String>();
    String n; // last read number from input

    void run(){
        n = scanner.next();
        while (!(n.equals("END"))) {
            words.add(n);
            n = scanner.next();
        }

        for (int i=0; i < words.size(); i++) {
            System.out.println( words.get( words.size() - i - 1 ) );
        }
    }



    
public static void main(String[] args) {
        (new EchoPit()).run();
    }
}

