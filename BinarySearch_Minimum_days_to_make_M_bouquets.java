public class BinarySearch_Minimum_days_to_make_M_bouquets {
    public static boolean isPossible(int arr[], int day, int m, int k) {
        int n = arr.length;
        int cnt = 0;
        int noOfBouquet = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                noOfBouquet += (cnt / k);
                cnt = 0;
            }

        }
        noOfBouquet += (cnt / k);
        return noOfBouquet >= m;
    }

    public static int rosesBouquet(int arr[], int k, int m) {
        long val = (long) m * k;
        int n = arr.length;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        if (val > n) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            mini = Math.min(arr[i], mini);
            maxi = Math.max(arr[i], maxi);
        }
        for (int i = mini; i <= maxi; i++) {
            if (isPossible(arr, i, m, k)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isPossibleOptimal(int arr[], int day, int m, int k) {
        int n = arr.length;
        int cnt = 0;
        int noOfBouquet = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                noOfBouquet += (cnt / k);
                cnt = 0;
            }

        }
        noOfBouquet += (cnt / k);
        return noOfBouquet >= m;
    }

    public static int rosesBouquetOptimal(int arr[], int k, int m) {
        int n = arr.length;
        long val = (long) m * k;
        if (val > n)
            return -1; // Impossible case.
        // Find maximum and minimum:
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }
        int low = mini;
        int high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;

    }

    public static void main(String[] args) {
        int[] arr = { 7, 7, 7, 7, 13, 11, 12, 7 };
        int k = 3;
        int m = 2;
        int ans = rosesBouquet(arr, k, m);
        int ans1=rosesBouquetOptimal(arr, k, m);
        if (ans == -1) {
            System.out.println("We cannot make m bouquets.");
        } else {

            System.out.println("We can make bouquets on day " + ans);
        }
        if (ans == -1) {
            System.out.println("We cannot make m bouquets.");
        } else {

            System.out.println("We can make bouquets on day " + ans1);
        }
    }
}
