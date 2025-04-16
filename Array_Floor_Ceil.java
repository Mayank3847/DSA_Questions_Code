public class Array_Floor_Ceil {
    public static int floor(int arr[], int x, int n) {
        int start = 0, end = n - 1, ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= x) {
                ans = arr[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static int ceil(int arr[], int x, int n) {
        int start = 0, end = n - 1, ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= x) {
                ans = arr[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static int[] getFloorAndCeil(int arr[], int x, int n) {
        int a = floor(arr, x, n);
        int b = ceil(arr, x, n);
        return new int[] { a, b };
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 4, 7, 8, 10 };
        int n = 6, x = 5;
        int[] ans = getFloorAndCeil(arr, x, n);
        System.out.println("The floor and ceil are: " + ans[0]
                + " " + ans[1]);
    }

}
