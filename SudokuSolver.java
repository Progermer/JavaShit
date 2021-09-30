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

    int solutionCounter = 0; // Solution counter

    // Is there a conflict when we fill in d at position (r, c)?
    boolean givesConflict(int r, int c, int d) {
        // TODO
        return false;
    }

    // Is there a conflict when we fill in d in row r?
    boolean rowConflict(int r, int d) {
        // TODO
        return false;
    }

    // Is there a conflict in column c when we fill in d?
    boolean columnConflict(int c, int d) {
        // TODO
        return false;
    }

    // Is there a conflict in the box at (r, c) when we fill in d?
    boolean boxConflict(int r, int c, int d) {
        // TODO
        return false;
    }
	
	// Is there a conflict in the asterisk when we fill in d?
	// Delete this comment and add your asteriskConflict method in its place.
	
	// Finds the next empty square (in "reading order").
    int[] findEmptySquare() {
        // TODO
        return new int[]{-1, -1};
    }

    // Find all solutions for the grid, and stores the final solution.
    void solve() {
        // TODO
    }

    // Print the sudoku grid.
    void print() {
        // TODO
    }

    // Run the actual solver.
    void solveIt() {
        // TODO
    }

    public static void main(String[] args) {
        (new SudokuSolver()).solveIt();
    }
}
