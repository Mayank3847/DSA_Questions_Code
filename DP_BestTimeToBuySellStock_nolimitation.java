public class DP_BestTimeToBuySellStock_nolimitation {
    public static int f(int index, int buy, int[] prices, int n, int dp[][]) {
        if (index == n) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];

        }
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[index] + f(index + 1, 0, prices, n, dp), f(index + 1, 1, prices, n, dp));

        }else{
            profit=Math.max(prices[index]+f(index+1, 1, prices, n, dp), f(index+1, 0, prices, n, dp));
        }
        dp[index][buy]=profit;
        return profit;
    }
    public static int getMaximum(int prices[],int n ){
        int dp[][]=new int [n][2];
        for(int i =0;i<dp.length;i++){
            for(int j =0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }

        }
        return f(0, 1, prices, n, dp);
    }
    public static void main(String[] args) {
        int prices[]={7,1,5,3,6,4};
        int n = prices.length;
        System.out.println(getMaximum(prices, n));
    }

}
