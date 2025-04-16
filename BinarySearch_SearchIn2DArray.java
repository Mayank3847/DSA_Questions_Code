public class BinarySearch_SearchIn2DArray {

    public static boolean searchBrute(int arr[][], int n, int m, int target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean binarySearch(int arr[], int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return false;

    }

    public static boolean searchBetter(int arr[][], int n, int m, int target) {
        for (int i = 0; i < n; i++) {
            if (arr[i][0] <= target && target < arr[i][m - 1]) {
                return binarySearch(arr[i], target);

            }
        }
        return false;
    }

    public static boolean searchOptimal(int arr[][], int target) {
        int n = arr.length, m = arr[0].length;

        int low = 0;
        int high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            if (arr[row][col] == target) {
                return true;

            } else if (arr[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 2, 6, 8, 10 },
                { 4, 9, 12, 15 },
                { 11, 14, 16, 20 }
        };
        int n = 4, m = 4;
        int target = 16;
        boolean result = searchBrute(matrix, n, m, target);
        System.out.println(result ? "true" : "false");
        boolean result1 = searchBetter(matrix, n, m, target);
        System.out.println(result1 ? "true" : "false");
        boolean result2 = searchOptimal(matrix, target);
        System.out.println(result2 ? "true" : "false");
    }
}