public class Array_LowerBound_UpperBound {
    public static int lowerBound(int arr[], int x, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] >= x) {
                return i;
            }
        }
        return n;
    }

    public static int lowerBoundOptimized(int arr[], int x, int n) {
        int low = 0, high = n - 1, ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }
        return ans;

    }

    public static int upperBound(int arr[], int x, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] > x) {
                return i;
            }
        }
        return n;
    }

    public static int upperBoundOptimal(int arr[], int x, int n) {
        int start = 0, end = n - 1, ans = n;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > x) {
                ans = mid;
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 15, 19 };
        int n = 5, x = 8;
        int ind = lowerBound(arr, x, n);
        System.out.println("The lower bound is the index (Brute Force) : " + ind);
        int ind1 = lowerBoundOptimized(arr, x, n);
        System.out.println("The lower bound is the index (Optimal Force) : " + ind1);
        int ind2 = upperBound(arr, x, n);
        System.out.println("The upper bound is the index (Brute Force) : " + ind2);
        int ind3 = upperBound(arr, x, n);
        System.out.println("The upper bound is the index (Optimal Force) : " + ind3);

    }

}
