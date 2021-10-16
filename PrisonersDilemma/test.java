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
    int maxX = 6;
    int maxY = 6;
    int minX = 1;
    int minY = 1;

    void run(){

        grid[0][0] = grid[maxX][maxY]; // top left border
        grid[maxX+1][0] = grid[minX][maxY]; // top right border
        grid[0][maxY+1] = grid[maxX][minY]; // bottom left border
        grid[maxX+1][maxY+1] = grid[minX][minY]; // bottom right border
        for (int i = 1; i <= maxX; i++){ // copies bottom values to top border
            grid[i][0] = grid[i][maxY];
        }
        for (int i = 1; i <= maxX; i++){ // copies top values to bottom border
            grid[i][maxY+1] = grid[1][minY];
        }
        for (int i = 1; i <= maxX; i++){ // copies left values to right border
            grid[maxX+1][i] = grid[minX][i];
        }
        for (int i = 1; i <= maxX; i++){ // copies right values to left border
            grid[0][i] = grid[maxX][i];
        }
    

    for (int y = 0; y <= maxY+1; y++){
        for (int x = 0; x<=maxX+1; x++){
            System.out.print(grid[y][x] + " ");
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
