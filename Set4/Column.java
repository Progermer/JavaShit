package Set4;
import java.util.*;
class Column {
    Scanner sc = new Scanner(System.in);
    void add() {
        int n;
        int m;
        int table[][];

        n = sc.nextInt();
        m = sc.nextInt();
        table = new int[n][m];
        for (int i=0; i<n; i++ ){
            for (int j=0; j<m; j++){
                table[i][j] = sc.nextInt();
            }
        }
        for (int i=0; i<m; i++ ){ // i = x, m = furthest column
            int sum = 0;
            for (int j=0; j<n-1; j++){ // j = y, n = furthest row 
                sum += table[j][i];
                table[n - 1][i] = sum;
            }    
            
        }
        for (int i=0; i<n; i++ ){
            for (int j=0; j<m; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        new Column().add();
    }
}