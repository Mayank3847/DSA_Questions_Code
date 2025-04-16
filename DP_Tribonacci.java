public class DP_Tribonacci {
    public static int tribonacci(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        for (int j = 0; j <= n; j++) {
            System.out.print(dp[j] + " ");
        }
        System.out.println();
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println("TRIBONACCI OF " + n + " -> " + tribonacci(n));
    }

}
