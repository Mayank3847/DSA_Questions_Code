public class Recurssion_CountAllSubsequenceWithSumK {
    public static int countSubsequenceWithSumK(int arr[], int n, int target) {
        if (target == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
 
        }
        int exclude = countSubsequenceWithSumK(arr, n - 1, target);
        int include = 0;
        if (arr[n - 1] <= target) {
            include = countSubsequenceWithSumK(arr, n - 1, target - arr[n - 1]);

        }
        return include + exclude;
    }

    public static boolean checkSubsequenceWithSumK(int arr[], int k) {
        return exists(arr, arr.length, k);
    }

    public static boolean exists(int arr[], int n, int k) {
        if (k == 0) {
            return true;
        }
        if (n == 0) {
            return false;

        }
        boolean exclude = exists(arr, n - 1, k);
        boolean include = false;
        if (arr[n - 1] <= k) {
            include = exists(arr, n - 1, k - arr[n - 1]);
        }
        return exclude || include;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 10, 6, 8 };
        int target = 10;
        int n = arr.length;
        System.out.println(countSubsequenceWithSumK(arr, n, target));

        System.out.println(checkSubsequenceWithSumK(arr, target));
    }

}
