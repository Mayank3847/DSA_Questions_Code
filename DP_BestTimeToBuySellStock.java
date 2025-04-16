public class DP_BestTimeToBuySellStock {
    public static int maximumProfit(int prices[]) {
        int n = prices.length;
        int minimum = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            int cost = prices[i] - minimum;
            maxProfit = Math.max(maxProfit, cost);
            minimum = Math.min(minimum, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = { 100, 180, 260, 310, 40, 535, 695 };
        System.out.println("The maximum profit ==> " + maximumProfit(prices));
    }

}
