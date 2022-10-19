package sudoku;

// The class should be changed to singleton design

enum PuzzleEnum {

}

/**
 * The sudoku number puzzle to be solved
 */
public class Puzzle {
    // All variables have package access
    // the number on the puzzle(
    int[][] numbers;
    boolean[][] isGiven;

    public Puzzle() {
        super();
        numbers = new int[GameBoardPanel.GRID_SIZE][GameBoardPanel.SUBGRID_SIZE];
        isGiven = new boolean[GameBoardPanel.GRID_SIZE][GameBoardPanel.SUBGRID_SIZE];
    }

    // Generate a new Puzzle given the number of cells to be guessed, which can be use
    // to control the difficulty level
    // This method shall set (or update) the arrays numbers and isGiven
    public void newPuzzle(int cellToGuess) {

        // The puzzle is hardcoded for illustation and testing
        int[][] hardcodedNumbers =
                {{5, 3, 4, 6, 7, 8, 9, 1, 2},
                        {6, 7, 2, 1, 9, 5, 3, 4, 8},
                        {1, 9, 8, 3, 4, 2, 5, 6, 7},
                        {8, 5, 9, 7, 6, 1, 4, 2, 3},
                        {4, 2, 6, 8, 5, 3, 7, 9, 1},
                        {7, 1, 3, 9, 2, 4, 8, 5, 6},
                        {9, 6, 1, 5, 3, 7, 2, 8, 4},
                        {2, 8, 7, 4, 1, 9, 6, 3, 5},
                        {3, 4, 5, 2, 8, 6, 1, 7, 9}};

        for (int row = 0; row < GameBoardPanel.GRID_SIZE; row++) {
            for (int col = 0; col < GameBoardPanel.SUBGRID_SIZE; col++) {
                numbers[row][col] = hardcodedNumbers[row][col];
            }
        }

        // Need to use input parameter cellsToGuess!
        // Hardcoded for testing, only 2 cells of "8" is NOT GIVEN
        boolean[][] hardcodedIsGiven =
                        {{true, true, true, true, true, false, true, true, true},
                        {true, true, true, true, true, true, true, true, false},
                        {true, true, true, true, true, true, true, true, true},
                        {true, true, true, true, true, true, true, true, true},
                        {true, true, true, true, true, true, true, true, true},
                        {true, true, true, true, true, true, true, true, true},
                        {true, true, true, true, true, true, true, true, true},
                        {true, true, true, true, true, true, true, true, true},
                        {true, true, true, true, true, true, true, true, true}};

        // Copy from hardcodedISGiven into array "isGiven"
        for (int row = 0; row < GameBoardPanel.GRID_SIZE; row++) {
            for (int col = 0; col < GameBoardPanel.SUBGRID_SIZE; col++) {
                isGiven[row][col] = hardcodedIsGiven[row][col];
            }
        }
    }
}
