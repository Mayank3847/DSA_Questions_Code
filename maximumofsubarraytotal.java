public class maximumofsubarraytotal {
    public static void maxSubArray(int numbers[]) {
        int currentSum = 0;
        int totalSubarrays = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = 0; j < numbers.length; j++) {
                int end = j;
                currentSum = 0;
                for (int k = start; k <= end; k++) {
                    currentSum += numbers[k];
                    System.out.print(numbers[k] + " ");
                    totalSubarrays++;
                    System.out.println();

                }
                System.out.println("CURRENT SUM:" + currentSum);
                if (maxSum < currentSum) {
                    maxSum = currentSum;

                }
            }

        }
        System.out.println("TOTAL NUMBERS OF SUBARRAYS: " + totalSubarrays);

        System.out.println("Maximum Sum: " + maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = { -2, -5, -7, 8, 10 };
        maxSubArray(numbers);
    }

}
