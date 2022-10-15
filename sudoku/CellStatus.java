package sudoku;

public enum CellStatus {
   GIVEN, // Clue
   TO_GUESS, // need to guess
   CORRECT_GUESS, // need to guess, correct guess
   WRONG_GUESS, // need to guess, wrong guess
}
