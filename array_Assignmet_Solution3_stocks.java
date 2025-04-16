import java.util.Scanner;

public class array_Assignmet_Solution3_stocks {
    public static int maxProfit(int prices[]) {
        int buyPrices = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buyPrices < prices[i]) {
                profit = Math.max(prices[i] - buyPrices, profit);
            } else {
                buyPrices = prices[i];

            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the length of the array
        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt();

        // Create an array with the given length
        int[] array = new int[length];

        // Loop to take input for each element of the array
        for (int i = 0; i < length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.println("THE MAXIMUM PROFIT IS " + maxProfit(array));
        scanner.close();

    }
}
