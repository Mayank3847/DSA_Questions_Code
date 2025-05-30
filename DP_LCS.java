public class DP_LCS {
    public static int lcsByRecurssion(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return lcsByRecurssion(str1, str2, n - 1, m - 1) + 1;
        } else {
            int ans1 = lcsByRecurssion(str1, str2, n - 1, m);
            int ans2 = lcsByRecurssion(str1, str2, ans1, m - 1);
            return Math.max(ans1, ans2);
        }
    }

    public static int lcsMemo(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = lcsMemo(str1, str2, n - 1, m - 1, dp) + 1;
        } else {
            int ans1 = lcsMemo(str1, str2, n - 1, m, dp);
            int ans2 = lcsMemo(str1, str2, n, m - 1, dp);
            return dp[n][m] = Math.max(ans1, ans2);

        }
    }

    public static int lcsTabulation(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }

        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        printDP(dp);
        return dp[n][m];
    }
    public static void printDP(int dp[][]){
        for(int i =0;i<dp.length;i++){
            for(int j =0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("LOWEST COMMON SUBSEQUENCE BY RECURSSION-> " + lcsByRecurssion(str1, str2, n, m));
        System.out.println("LOWEST COMMON SUBSEQUENCE BY MEMOIZATION-> " + lcsMemo(str1, str2, n, m, dp));
        System.out.println("LOWEST COMMON SUBSEQUENCE BY TABULATION-> " + lcsTabulation(str1, str2));

    }

}
