public class Sudoku_Solver_Backtracking {

    public boolean isSafe(char[][] board, int row, int col, int number) {
        // Check the row and column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char) (number + '0')) {
                return false;
            }
            if (board[row][i] == (char) (number + '0')) {
                return false;
            }
        }

        // Check the 3x3 grid
        int startingRow = (row / 3) * 3;
        int startingCol = (col / 3) * 3;
        for (int i = startingRow; i < startingRow + 3; i++) {
            for (int j = startingCol; j < startingCol + 3; j++) {
                if (board[i][j] == (char) (number + '0')) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean helper(char[][] board, int row, int col) {
        // Base case------- If we have reached the end of the board
        if (row == board.length) {
            return true;
        }

        // Move to the next row if we have reached the end of the column
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == board.length) {
            nextRow++;
            nextCol = 0;
        }

        // If the cell is already filled, move to the next cell
        if (board[row][col] != '-') {
            return helper(board, nextRow, nextCol);
        } else {
            // Try placing numbers from 1 to 9 in the cell
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, row, col, i)) {
                    board[row][col] = (char) (i + '0');
                    if (helper(board, nextRow, nextCol)) {
                        return true;
                    }
                    // Backtrack
                    board[row][col] = '-';
                }
            }
            return false; // If no number is valid, return false
        }
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'1', '-', '3', '6', '-', '4', '5', '-', '9'},
                {'-', '-', '-', '-', '5', '-', '-', '-', '-'},
                {'9', '-', '5', '-', '-', '7', '-', '-', '2'},
                {'-', '-', '8', '7', '-', '3', '-', '-', '-'},
                {'3', '6', '-', '-', '-', '-', '4', '-', '-'},
                {'-', '-', '4', '-', '6', '-', '-', '3', '-'},
                {'4', '-', '-', '-', '7', '-', '9', '-', '3'},
                {'-', '-', '9', '4', '-', '-', '-', '5', '-'},
                {'8', '-', '6', '-', '2', '-', '-', '1', '-'}
        };

        Sudoku_Solver_Backtracking solver = new Sudoku_Solver_Backtracking();
        solver.solveSudoku(board);

        // Print the solved Sudoku board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
