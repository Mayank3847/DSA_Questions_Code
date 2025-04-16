public class knight_tour_backtrackking {
    static int N = 8;

    public static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);

    }

    public static void printSol(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solveKnight() {
        int sol[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }
        int xmove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int ymove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        sol[0][0] = 0;
        if (!solveKTUtil(0, 0, 1, sol, xmove, ymove)) {
            System.out.println("SOLUTION DOES NOT EXIST!!!");
            return false;
        } else {
            printSol(sol);
        }
        return true;

    }

    public static boolean solveKTUtil(int x, int y, int movei, int sol[][], int xmove[], int ymove[]) {
        int k, next_x, next_y;
        if (movei == N * N) {
            return true;
        }
        for (k = 0; k < 8; k++) {
            next_x = x + xmove[k];
            next_y = y + ymove[k];

            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, sol, xmove, ymove))
                    return true;
                else
                    sol[next_x][next_y] = -1;
                // backtracking

            }

        }
        return false;
    }

    public static void main(String[] args) {
        solveKnight();
    }

}
