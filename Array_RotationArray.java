public class Array_RotationArray {
    public static void rotateRight(int arr[], int k) {
        int n = arr.length;
        if (n == 0) {
            return;
        }
        k = k % n;
        // if (k > n) {
        //     return;
        // }
        int temp[] = new int[n];
        for (int i = n - k; i < n; i++) {
            temp[i - n + k] = arr[i];
        }
        for (int i = n - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];

        }
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }

    }

    public static void rotateLeft(int arr[], int k) {
        int n = arr.length;
        if (n == 0) {
            return;
        }
        k = k % n;
        // if (k > n) {
        //     return;
        // }
        int temp[] = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        for (int i = 0; i < n - k; i++) {
            arr[i] = arr[i + k];
        }
        for (int i = n - k; i < n; i++) {
            arr[i] = temp[i - n + k];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int n = arr.length;
        int k = 2;
        
        // Rotate right
        rotateRight(arr, k);
        System.out.println("After Rotating the elements to right: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Reset array
        arr = new int[]{ 1, 2, 3, 4, 5, 6, 7 };
        
        // Rotate left
        rotateLeft(arr, k);
        System.out.println("After Rotating the elements to left: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
