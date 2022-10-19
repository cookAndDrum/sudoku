package sudoku;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class Cell extends JTextField{
    // prevent serial warning
    private static final long serialVerionUID = 1L;

    // Define named constant for JTextField's colors and fonts
    // to be chosen based on Cell Status (enum class)
    public static final Color BG_GIVEN = new Color (240, 240, 240);
    public static final Color FG_GIVEN = Color.BLACK;
    public static final Color FG_NOT_GIVEN = Color.GRAY;
    public static final Color BG_TO_GUESS  = Color.YELLOW;
    public static final Color BG_CORRECT_GUESS  = new Color(0, 216, 0);
    public static final Color BG_WRONG_GUESS  = new Color(216, 0, 0);
    public static final Font FONT_NUMBERS = new Font("OCR A Extended", Font.PLAIN, 28);

    // Define properties (package-visible)
    /** The row and column number [0 - 8] of this cell */
    int row, col;
    /** The puzzle number [1-9] for this cell */
    int number;
    /** The status of this cell defined in enum CellStatus */
    CellStatus status;

    /**
     * Constructor
     */
    public Cell (int row, int col)
    {
        super();
        this.row = row;
        this.col = col;
        // Inherited from JTextField: Beautify all the cells once for all
        super.setHorizontalAlignment(JTextField.CENTER);
        super.setFont(FONT_NUMBERS);
    }

    /**
     * Reset this cell for a new game, given the puzzle number and isGiven
     * @param number
     * @param isGiven
     */
    public void newGame (int number, boolean isGiven)
    {
        this.number = number;
        status = isGiven ? CellStatus.GIVEN : CellStatus.TO_GUESS;

        // java.awt.Graphics?
        paint(); // paint itself
    }

    public void paint() {
        if (status == CellStatus.GIVEN) {
            // Inherited from JTextField: Set display properties
            super.setText(number + ""); // number from constructed
            super.setEditable(false);
            super.setBackground(BG_GIVEN);
            super.setForeground(FG_GIVEN);
        } else if (status == CellStatus.TO_GUESS) {
            super.setText("");
            super.setEditable(true);
            super.setBackground(BG_TO_GUESS);
            super.setForeground(FG_NOT_GIVEN);
        } else if (status == CellStatus.CORRECT_GUESS) {
            super.setBackground(BG_CORRECT_GUESS);
        } else if (status == CellStatus.WRONG_GUESS) {
            super.setBackground(BG_WRONG_GUESS);
        }
    }


}
