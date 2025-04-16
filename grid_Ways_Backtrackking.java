public class grid_Ways_Backtrackking {
    public static int gridWays(int i, int j, int n, int m) {
        // base case
        if (i == n - 1 && j == m - 1) {// condition for last cell
            return 1;
        }
        // condition for out of boundary
        else if (i == n || j == m) {

            return 0;
        }
        // recursive function
        int ways1 = gridWays(i, j + 1, n, m);// for right cells
        int ways2 = gridWays(i + 1, j, n, m);// for down cells
        return ways1 + ways2;

    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out
                .println("THE TOTAL NUMBER OF GRIDWAYS FOR n = " + n + " and m = " + m + " is:" + gridWays(0, 0, n, m));
    }

}
