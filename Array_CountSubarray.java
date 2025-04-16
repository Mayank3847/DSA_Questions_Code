public class Array_CountSubarray {
    public static int subArraySumBrute(int arr[], int keySum) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];

                }
                if (sum == keySum) {
                    count++;
                }
            }
        }
        return count;

    }


    


    public static int subArraySumBetter(int arr[], int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    

    public static void main(String[] args) {
        int arr[] = { 3, 1, 2, 4 };
        // int arr[] = { 1, 2 };
        int keySum = 3;
        System.out.println("Count Of SubArray Of Sum equal to K By Brute Fore -> " + subArraySumBrute(arr, keySum));
        System.out.println("Count Of SubArray Of Sum equal to K By Better Aproach -> " + subArraySumBetter(arr, keySum));

    }

}
