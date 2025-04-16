import java.util.Arrays;

public class Array_Merge2SortedArray {
    public static void merge(int arr1[], int arr2[], int n, int m) {
        int arr3[] = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                k++;
                i++;

            } else {
                arr3[k] = arr2[j];
                k++;
                j++;
            }
        }
        while (i < n) {
            arr3[k] = arr1[i];
            k++;
            i++;

        }
        while (j < m) {
            arr3[k] = arr2[j];
            k++;
            j++;

        }
        for (int ab = 0; ab < n + m; ab++) {
            if (ab < n) {
                arr1[ab] = arr3[ab];
            } else {
                arr2[ab - n] = arr3[ab];
            }
        }
    }

    // Optimal Solution ----->>>
    public static void mergeOptimal(int arr1[], int arr2[], int n, int m) {
        int left = n - 1;
        int right = 0;
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;

            } else {
                break;
            }

        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 4, 8, 10 };
        int[] arr2 = { 2, 3, 9 };
        int n = 4, m = 3;
        merge(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        mergeOptimal(arr1, arr2, n, m);
       // merge(arr1, arr2, n, m);
        System.out.println("The merged arrays are(Optimal Solution):");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
}
