import java.util.*;

public class Recurssion_N_Queens {
    public static List<List<String>> nQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], " - ");
        }
        solve(0, ans, board, n);
        return ans;
    }

    private static void solve(int col, List<List<String>> ans, String[][] board, int n) {
        if (col == n) {
            addSolution(board, ans, n);
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = " Q "; // Place queen
                solve(col + 1, ans, board, n);
                board[row][col] = "-"; // Backtrack
            }
        }
    }

    private static boolean isSafe(int row, int col, String[][] board, int n) {
        int x = row, y = col;
        while (y >= 0) {
            if (board[x][y].equals(" Q ")) {
                return false;
            }
            y--;
        }

        x = row;
        y = col;
        while (x >= 0 && y >= 0) {
            if (board[x][y].equals(" Q ")) {
                return false;
            }
            x--;
            y--;
        }
        x = row;
        y = col;
        while (x < n && y >= 0) {
            if (board[x][y].equals(" Q ")) {
                return false;
            }
            x++;
            y--;
        }
        return true;
    }

    public static void addSolution(String[][] board, List<List<String>> ans, int n) {
        List<String> temp = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(board[i][j]);
            }
            temp.add(row.toString());
        }
        ans.add(new ArrayList<>(temp));
    }

    public static List<List<String>> nQueenOptimized(int n) {
        List<List<String>> ans = new ArrayList<>();
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], "-");

            
        }
        Set<Integer> leftRow = new HashSet<>();
        Set<Integer> lowerDiagonal = new HashSet<>();
        Set<Integer> upperDiagonal = new HashSet<>();
        solve1(0, ans, board, n, leftRow, lowerDiagonal, upperDiagonal);
        return ans;

    }

    public static void solve1(int col, List<List<String>> ans, String[][] board, int n,
            Set<Integer> leftRow, Set<Integer> lowerDiagonal, Set<Integer> upperDiagonal) {
        if (col == n) {
            addSolution(board, ans, n);
            return;
        }
        for (int row = 0; row < n; row++) {
            if (!leftRow.contains(row) && !lowerDiagonal.contains(row + col) && !upperDiagonal.contains(col - row)) {
                board[row][col] = "Q";
                leftRow.add(row);
                lowerDiagonal.add(row + col);
                upperDiagonal.add(col - row);
                solve1(col + 1, ans, board, n, leftRow, lowerDiagonal, upperDiagonal);

                // Backtrack: Remove Queen
                board[row][col] = "-";
                leftRow.remove(row);
                lowerDiagonal.remove(row + col);
                upperDiagonal.remove(col - row);

            }
        }
    }

    public static void main(String[] args) {
        int n = 4;

        // List<List<String>> solutions = nQueens(n);

        // System.out.println("Total Solutions: " + solutions.size());
        // for (List<String> solution : solutions) {
        // for (String row : solution) {
        // System.out.println(row);
        // }
        // System.out.println();

        // int n = 4; // Change n for different board sizes
        List<List<String>> solutions1 = nQueenOptimized(n);

        System.out.println("Total Solutions:(Optimized) " + solutions1.size());
        int count = 1;
        for (List<String> solution1 : solutions1) {
            System.out.println("Solution (Optimized) " + count + ":");
            for (String row : solution1) {
                for (char c : row.toCharArray()) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }
            System.out.println();
            count++;
        }
       }
}
