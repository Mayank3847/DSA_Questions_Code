public  class Recurssion_Backtracking_Sudoko {
    public static boolean solveSuduko(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '0' || board[i][j] == '-') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, i, j, ch)) {
                            board[i][j] = ch;

                            if (solveSuduko(board)) {
                                return true;
                            } else {
                                board[i][j] = '0';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char board[][], int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch) {
                return false;
            }
            if (board[row][i] == ch) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) {
                return false;
            }
        }
        return true;

    } 

    public static void main(String[] args) {

        char[][] board = {
                { '9', '5', '7', '-', '1', '3', '-', '8', '4' },
                { '4', '8', '3', '-', '5', '7', '1', '-', '6' },
                { '-', '1', '2', '-', '4', '9', '5', '3', '7' },
                { '1', '7', '-', '3', '-', '4', '9', '-', '2' },
                { '5', '-', '4', '9', '7', '-', '3', '6', '-' },
                { '3', '-', '9', '5', '-', '8', '7', '-', '1' },
                { '8', '4', '5', '7', '9', '-', '6', '1', '3' },
                { '-', '9', '1', '-', '3', '6', '-', '7', '5' },
                { '7', '-', '6', '1', '8', '5', '4', '-', '9' }
        };
        solveSuduko(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

}
