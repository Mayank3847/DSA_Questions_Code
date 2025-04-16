import java.util.Arrays;

public class insertionSort_1 {
    public static void insertionSort_Descending(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 6, 2, 1, 8, 7, 4, 5, 3, 1 };
        System.out.println("ARRAY BEFORE SORTING:" + Arrays.toString(arr));
        insertionSort_Descending(arr);
        System.out.println("ARRAYS AFTER SORTING: " + Arrays.toString(arr));

    }

}
