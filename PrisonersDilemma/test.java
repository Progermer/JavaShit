package PrisonersDilemma;

public class test {
    int grid[][] = new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 2, 3, 4, 5, 6, 0},
        {0, 1, 2, 3, 4, 5, 6, 0},
        {0, 1, 2, 3, 4, 5, 6, 0},
        {0, 1, 2, 3, 4, 5, 6, 0},
        {0, 1, 2, 3, 4, 5, 6, 0},
        {0, 1, 2, 3, 4, 5, 6, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
    };

    int test[][] = new int[][]{
        {1, 2, 3},
        {1, 2, 3},
        {1, 2, 3},
    };
    int maxRow = 6;
    int maxColumn = 6;
    int minRow = 1;
    int minColumn = 1;

    void run(){

        grid[0][0] = grid[maxRow][maxColumn]; // top left border
        grid[maxRow+1][0] = grid[minRow][maxColumn]; // bottom left border
        grid[0][maxColumn+1] = grid[maxRow][minColumn]; // top right border
        grid[maxRow+1][maxColumn+1] = grid[minRow][minColumn]; // bottom right border
        for (int i = 1; i <= maxRow; i++){ 
            grid[i][0] = grid[i][maxColumn]; // copies right values to left border
            grid[i][maxColumn+1] = grid[i][minColumn]; // copies left values to right border
            grid[maxRow+1][i] = grid[minRow][i]; // copies top values to bottom border
            grid[0][i] = grid[maxRow][i]; // copies bottom values to top border
        }
    

    for (int row = 0; row <= maxRow+1; row++){
        for (int col = 0; col <= maxColumn+1; col++){
            System.out.print(grid[row][col] + " ");
        }
        System.out.println();
    }
    test[1][2] = 0;
    for (int x = 0; x < 3; x++){
        for (int y = 0; y < 3; y++){
            System.out.print(test[x][y] + " ");
        }
        System.out.println();
    }
}
    public static void main( String[] a ) {
        (new test()).run();
    }
}
