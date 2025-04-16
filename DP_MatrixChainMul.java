public class DP_MatrixChainMul {
    public static int mcm(int arr[], int i, int j) {
        if (i == j) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm(arr, i, k);// Ai............Ak..--->>>Ai=arr[i-1]*arr[k]

            int cost2 = mcm(arr, k + 1, j);// Ak+1..............j..---->>>>Aj=arr[k]*arr[j];
            int cost3 = arr[i - 1] * arr[j] * arr[k];
            int finalCost = cost1 + cost2 + cost3;
            minCost = Math.min(minCost, finalCost);
        }
        return minCost;
    }

    // MATRIX CHAIN MULTIPLICATION BY MEMOIZATION
    public static int mcmMemo(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            return 0;

        }
        if (dp[i][j] != -1) {
            return dp[i][j];

        }
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost1 = mcmMemo(arr, i, k, dp);
            int cost2 = mcmMemo(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[j] * arr[k];

            int finalCost = cost1 + cost2 + cost3;
            minCost = Math.min(minCost, finalCost);

        }
        return dp[i][j] = minCost;

    }

    // MATRIX CHAIN MULTIPLICATION BY TABULATION
    public static int mcmTab(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    if (i == j) {
                        dp[i][j] = 0;
                    }
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[j] * arr[k];
                    int finalCost = cost1 + cost2 + cost3;
                    dp[i][j] = Math.min(dp[i][j], finalCost);

                }
            }
        }
        printDP(dp);
        return dp[1][n - 1];
    }

    public static void printDP(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(" MINIMUM COST(BY RECURSSION) : " + mcm(arr, 1, n - 1));
        System.out.println(" MINIMUM COST(BY MEMOIZATION) : " + mcmMemo(arr, 1, n - 1, dp));
        System.out.println(" MINIMUM COST(BY TABULATION) : " + mcmTab(arr));
        System.out.println("TABLE FOR MEMOIZATION ");
        printDP(dp);

    }

}
