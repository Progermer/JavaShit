/**
 * Class that solves the Asterisk Sudoku.
 * Prints the number of solutions of a Sudoku if there are multiple. If there is only a single solution, prints this solution instead.
 *
 * by <<Gabrielius Rosinas 1655175>>
 * and <<Tomas Sutavicius 1704915>>
 * as group <<68>>
 */

class SudokuSolver {

    int SUDOKU_SIZE = 9;          // Size of the grid.
    int SUDOKU_MIN_NUMBER = 1;    // Minimum digit to be filled in.
    int SUDOKU_MAX_NUMBER = 9;    // Maximum digit to be filled in.
    int SUDOKU_BOX_DIMENSION = 3; // Dimension of the boxes (sub-grids that should contain all digits).

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
        if ((rowConflict(r, d) || columnConflict(c, d) || boxConflict(r, c, d) || asteriskConflict(r, c, d))){
            return true;
        }
        return false;
    }

    // Is there a conflict when we fill in d in row r?
    boolean rowConflict(int r, int d) { // Returns true if there is a conflict
        for (int i = 0; i < 9; i++) {
            if (grid[r][i] == d) {
                return true;
            } 
        }
        return false;
    }

    // Is there a conflict in column c when we fill in d?
    boolean columnConflict(int c, int d) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][c] == d) {
                return true;
            }
        }
       return false;
    }

    // Is there a conflict in the box at (r, c) when we fill in d?
    boolean boxConflict(int r, int c, int d) {
        int rowStart = (r/SUDOKU_BOX_DIMENSION) * SUDOKU_BOX_DIMENSION; // rowStart of r[0:2] = 0, rowStart of r[3:5] = 3, rowStart of r[6:8] = 6 
        int rowEnd = rowStart + SUDOKU_BOX_DIMENSION; // rowEnd of r[0:2] = 3, rowStart of r[3:5] = 6, rowStart of r[0:2] = 9 
        int colStart = (c/SUDOKU_BOX_DIMENSION) * SUDOKU_BOX_DIMENSION; // same thinking as above for the rest
        int colEnd =  colStart + SUDOKU_BOX_DIMENSION;
        
        for (int i = rowStart; i < rowEnd ; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (grid[i][j] == d) {
                    return true;
                }
            }
        }
        return false;
    }
	
	// Is there a conflict in the asterisk when we fill in d?
	boolean asteriskConflict(int r, int c, int d) {
        int[][] asteriksLocation = new int[][] {{1,4},{2,2},{2,6},{4,1},{4,4},{4,7},{6,2},{6,6},{7,4}};// Array containing location of all squares in asterisk
        boolean location = false;
        for (int i = 0; i < asteriksLocation.length; i++ ){
                if( r == asteriksLocation[i][0] && c == asteriksLocation[i][1]) { // Checks if r and c match any of the asterisk locations 
                    location = true;
                    break;
                }
        }
        if (location) {
            for (int i = 0; i < asteriksLocation.length; i++ ) { // Goes through every element checking if values in the asterisk locations match d
                int a = asteriksLocation[i][0];
                int b = asteriksLocation[i][1];
                if (grid[a][b] == d) {
                    return true;
                    
                }
            }
        }
        return false;

    }

	// Finds the next empty square (in "reading order").
    int[] findEmptySquare() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Find all solutions for the grid, and stores the final solution.
    void solve() {
        int[] emptySquare = findEmptySquare();
        int r = emptySquare[0];
        int c = emptySquare[1];
        for (int i = 1; i <= 9; i++) {
            if (r != -1) { // checks if there is an available next cell
                if (!givesConflict(r, c, i)) { // checks whether or not there is a conflict 
                    grid[r][c] = i;
                    if (findEmptySquare()[0] == -1 ) { // Checks if next cell is final cell which means the sudoku is solved
                        firstSolution();
                        solutionCounter++;
                }
                    solve();
                    grid[r][c] = 0;
                } 
            }         
        } 
    }

    void firstSolution() { // Copies current (finished) grid into finalGrid
        finalGrid = new int[grid.length][grid.length];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                finalGrid[i][j] = grid[i][j];
            }
        }
    }

    // Print the sudoku grid.
    void print() {
        grid = finalGrid;
        System.out.println("+-----------------+"); // Top line
        for (int i = 0; i < 9; i++) {
            if (i == 1 || i == 7) {
                String test = String.format("|%d %d %d|%d>%d<%d|%d %d %d|", 
                grid[i][0], grid[i][1], grid[i][2], grid[i][3], grid[i][4], grid[i][5], grid[i][6], grid[i][7], grid[i][8]);
                System.out.println(test);
            } else if (i == 2 || i == 6) {
                String test = String.format("|%d %d>%d|%d %d %d|%d<%d %d|",
                grid[i][0], grid[i][1], grid[i][2], grid[i][3], grid[i][4], grid[i][5], grid[i][6], grid[i][7], grid[i][8]);
                System.out.println(test);
            } else if (i==4) {
                String test = String.format("|%d>%d<%d|%d>%d<%d|%d>%d<%d|", 
                grid[i][0], grid[i][1], grid[i][2], grid[i][3], grid[i][4], grid[i][5], grid[i][6], grid[i][7], grid[i][8]);
                System.out.println(test);
            } else {
                String test = String.format("|%d %d %d|%d %d %d|%d %d %d|", 
                grid[i][0], grid[i][1], grid[i][2], grid[i][3], grid[i][4], grid[i][5], grid[i][6], grid[i][7], grid[i][8]);
                System.out.println(test); 
            }
            if ((i+1) % 3 == 0) {
                System.out.println("+-----------------+"); // Bottom line
            }
        }
        
    
    }

    // Run the actual solver.
    void solveIt() {
        solve();
        if (solutionCounter > 1) {
            System.out.println(solutionCounter);
        } else if (solutionCounter == 1) {
            print();
        } //else {
            //System.out.println("no solution sir");
        //}
    }

    public static void main(String[] args) {
        (new SudokuSolver()).solveIt();
    }
}
  