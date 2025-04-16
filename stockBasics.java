public class stockBasics {
    public static int sell_and_buy_stocks(int price[]) {
        int buyPrice = Integer.MAX_VALUE;

        int maxProfit = 0;
        for (int i = 0; i < price.length; i++) {
            if (buyPrice < price[i]) {
                int profit = price[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);

            } else {
                buyPrice = price[i];
            }
        }
        return maxProfit;

    }

    public static void main(String[] args) {
        int price[] = { 7000, 1000, 5000, 3000, 6000, 4000 };
        System.out.println(sell_and_buy_stocks(price));

    }
}
