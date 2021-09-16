package Set3;
public class MaxInt {
    
    public void run(){
        int n = 100000;
        int max = 0;
        while (n!=1){
            if ((max+=n) >= 0){
                max+=n;
            } else {
                n/=2;
            }
            System.out.println(max);
        }
    }

    public static void main(String[] args){
        (new MaxInt()).run();
    }
    
}
