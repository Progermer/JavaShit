/**
 * Class that solves the Asterisk Sudoku.
 * Prints the number of solutions of a Sudoku if there are multiple. If there is only a single solution, prints this solution instead.
 *
 * by <<TODO YOUR NAME AND ID HERE>>
 * and <<TODO YOUR PARTNERS NAME AND ID HERE>>
 * as group <<TODO GROUP NUMBER HERE>>
 */
class SudokuSolver {

    int SUDOKU_SIZE = 9;          // Size of the grid.
    int SUDOKU_MIN_NUMBER = 1;    // Minimum digit to be filled in.
    int SUDOKU_MAX_NUMBER = 9;    // Maximum digit to be filled in.
    int SUDOKU_BOX_DIMENSION = 3; // Dimension of the boxes (sub-grids that should contain all digits).
    // int rempty = 0;
    // int cempty = 0;

    int[][] grid = new int[][] {  // The puzzle grid; 0 represents empty.
        { 0, 9, 0,   7, 3, 0,    4, 0, 0 },    // One solution.
        { 0, 0, 0,   0, 0, 0,    5, 0, 0 },
        { 3, 0, 0,   0, 0, 6,    0, 0, 0 },

        { 0, 0, 0,   0, 0, 2,    6, 4, 0 },
        { 0, 0, 0,   6, 5, 1,    0, 0, 0 },
        { 0, 0, 6,   9, 0, 7,    0, 0, 0 },

        { 5, 8, 0,   0, 0, 0,    0, 0, 0 },
        { 9, 0, 0,   0, 0, 3,    0, 2, 5 },
        { 6, 0, 3,   0, 0, 0,    8, 0, 0 },
    };
    
    int[][] finalGrid = new int[9][9];
    int solutionCounter = 0; // Solution counter

    // Is there a conflict when we fill in d at position (r, c)?
    boolean givesConflict(int r, int c, int d) {
        boolean bool = false;
        if ((rowConflict(r, d) || columnConflict(c, d) || boxConflict(r, c, d) || asteriskConflict(r, c, d))){
            bool = true;
        }
        return bool;
    }

    // Is there a conflict when we fill in d in row r?
    boolean rowConflict(int r, int d) { // Returns true if there is a conflict
        for (int i = 0; i < 9; i++){
            if (grid[r][i] == d){
                return true;
            } 
        }
        return false;
    }

    // Is there a conflict in column c when we fill in d?
    boolean columnConflict(int c, int d) {
        for (int i = 0; i < 9; i++) {
            if(grid[i][c] == d) {
                return true;
            }
        }
       return false;
    }

    // Is there a conflict in the box at (r, c) when we fill in d?
    boolean boxConflict(int r, int c, int d) {
        int rowStart = (r/SUDOKU_BOX_DIMENSION) * SUDOKU_BOX_DIMENSION; // if boxrow 1 -> starts at 0, 2 -> s/a 3, 3 s/a -> 6
        int rowEnd = rowStart + SUDOKU_BOX_DIMENSION;
        int colStart = (c/SUDOKU_BOX_DIMENSION) * SUDOKU_BOX_DIMENSION; 
        int colEnd =  colStart + SUDOKU_BOX_DIMENSION;

        for (int i = rowStart; i < rowEnd ; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if(grid[i][j] == d) {
                    return true;
                }
            }
        }
        return false;
    }
	
	// Is there a conflict in the asterisk when we fill in d?
	boolean asteriskConflict(int r, int c, int d){
        int[][] asteriksLocation = new int[][] {{1,4},{2,2},{2,6},{4,1},{4,4},{4,7},{6,2},{6,6},{7,4}};// Array containing location of all squares in asterisk
        boolean location = false;
        for (int i = 0; i < asteriksLocation.length; i++ ){
                if( r == asteriksLocation[i][0] && c == asteriksLocation[i][1]) {
                    location = true;
                    //System.out.println(location);
                    break;
                }
        }
        if (location) {
            for(int i = 0; i < asteriksLocation.length; i++ ) {
                int a = asteriksLocation[i][0];
                int b = asteriksLocation[i][1];
                if(grid[a][b] == d) {
                    return true;
                    
                }
            }
        }
        //System.out.println(bool);
        return false;

    }

   
	int cempty = 0;
    int rempty = 0;
	// Finds the next empty square (in "reading order").
    int[] findEmptySquare() {
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (grid[i][j] == 0){
                    cempty = j;
                    rempty = i;
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Find all solutions for the grid, and stores the final solution.
    void solve() {
       int[] emptySquare = findEmptySquare();
       System.out.println(String.format("(%d,%d)", emptySquare[0], emptySquare[1] ));
       if (emptySquare[0] != -1) {
            int r = emptySquare[0];
            int c = emptySquare[1];
            for (int i = 1; i <= 9; i++) {
                if (!givesConflict(r, c, i)) {
                    grid[r][c] = i;
                    solve();
                    grid[r][c] = 0;
                }
            }
            if (r == 9 && c == 9){
                finalGrid = grid;
            } 
       }
    }

    // Print the sudoku grid.
    void print(){
        System.out.println("+-----------------+");
        
        for (int i = 0; i < 9; i++){
            if (i == 1 || i == 7){
                String test = String.format("|%d %d %d|%d>%d<%d|%d %d %d|", 
                grid[i][0], grid[i][1], grid[i][2], grid[i][3], grid[i][4], grid[i][5], grid[i][6], grid[i][7], grid[i][8]);
                System.out.println(test);
            } else if (i == 2 || i == 6){
                String test = String.format("|%d %d>%d|%d %d %d|%d<%d %d|",
                grid[i][0], grid[i][1], grid[i][2], grid[i][3], grid[i][4], grid[i][5], grid[i][6], grid[i][7], grid[i][8]);
                System.out.println(test);
            } else if (i==4){
                String test = String.format("|%d>%d<%d|%d>%d<%d|%d>%d<%d|", 
                grid[i][0], grid[i][1], grid[i][2], grid[i][3], grid[i][4], grid[i][5], grid[i][6], grid[i][7], grid[i][8]);
                System.out.println(test);
            } else {
                String test = String.format("|%d %d %d|%d %d %d|%d %d %d|", 
                grid[i][0], grid[i][1], grid[i][2], grid[i][3], grid[i][4], grid[i][5], grid[i][6], grid[i][7], grid[i][8]);
                System.out.println(test); 
            }
            if ((i+1) % 3 == 0){
                System.out.println("+-----------------+");
            }
        }
        
    
    }

    void printFinal(){
        System.out.println("+-----------------+");
        
        for (int i = 0; i < 9; i++){
            if (i == 1 || i == 7){
                String test = String.format("|%d %d %d|%d>%d<%d|%d %d %d|", 
                finalGrid[i][0], finalGrid[i][1], finalGrid[i][2], finalGrid[i][3], finalGrid[i][4], finalGrid[i][5], finalGrid[i][6], finalGrid[i][7], finalGrid[i][8]);
                System.out.println(test);
            } else if (i == 2 || i == 6){
                String test = String.format("|%d %d>%d|%d %d %d|%d<%d %d|",
                finalGrid[i][0], finalGrid[i][1], finalGrid[i][2], finalGrid[i][3], finalGrid[i][4], finalGrid[i][5], finalGrid[i][6], finalGrid[i][7], finalGrid[i][8]);
                System.out.println(test);
            } else if (i==4){
                String test = String.format("|%d>%d<%d|%d>%d<%d|%d>%d<%d|", 
                finalGrid[i][0], finalGrid[i][1], finalGrid[i][2], finalGrid[i][3], finalGrid[i][4], finalGrid[i][5], finalGrid[i][6], finalGrid[i][7], finalGrid[i][8]);
                System.out.println(test);
            } else {
                String test = String.format("|%d %d %d|%d %d %d|%d %d %d|", 
                finalGrid[i][0], finalGrid[i][1], finalGrid[i][2], finalGrid[i][3], finalGrid[i][4], finalGrid[i][5], finalGrid[i][6], finalGrid[i][7], finalGrid[i][8]);
                System.out.println(test); 
            }
            if ((i+1) % 3 == 0){
                System.out.println("+-----------------+");
            }
        }
        
    
    }

    // Run the actual solver.
    void solveIt() {
        solve();
        printFinal();
    }

    public static void main(String[] args) {
        (new SudokuSolver()).solveIt();
    }
}
  