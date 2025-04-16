public class Sorting_Quick_Sort {
    public static int Partition(int arr[], int low, int high) {
        // partition part
        int pivot = arr[high];
        int i = low - 1;
        // for transve and compare the all elements with pivot element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swapping
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }
        // pivot k sbse chhote element me to suru m aa gya aab pivot element ko apne
        // jagah pr jane k liye i ko tansvere krke jgh bnana hoga or i ko fir swapping
        i++;
        int temp = arr[i];
        arr[i] = pivot;    
        arr[high] = temp;
        return i;
    }

    public static void QuickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivot_index = Partition(arr, low, high);
            QuickSort(arr, low, pivot_index - 1);
            QuickSort(arr, pivot_index + 1, high);

        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        int n = arr.length;
        QuickSort(arr, 0, n - 1);
        // print array----
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
