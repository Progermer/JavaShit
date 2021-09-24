package Set5;
public class FunFunctions {
    double tabl[][] = new double[13][2];
    double f(double x){
        return (Math.pow(x,2)-(2*x)-3);
    }

    void table(){
        double j = 3;
        for (int i = 0; i<13; i++){ 
            tabl[i][0] = j;
            tabl[i][1] = f(j);
            j=j-0.5;
        }
    
        for (int i = 0; i<13; i++){
            for (int k = 0; k<2; k++){
                System.out.print(tabl[i][k]%8.2f + "     ");
            }
            System.out.println();
        }

}



    public static void main(String[] args) {
        (new FunFunctions()).table();
    }
}
