import java.util.*;

public class BinarySearch_KthElement {
    public static int kthEle(int arr1[], int arr2[], int key) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int arr3[] = new int[n1 + n2];
        int k = 0;
        for (int i = 0; i < n1; i++) {
            arr3[k++] = arr1[i];
            // k++;
        }
        for (int j = 0; j < n2; j++) {
            arr3[k++] = arr2[j];
            // k++;
        }
        Arrays.sort(arr3);
        return arr3[key - 1];

    }

    public static int kthEleBrute(int arr1[], int arr2[], int k) {
        int m = arr1.length;
        int n = arr2.length;
        int arr3[] = new int[m + n];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];

            }
            while (i < m) {
                arr3[index++] = arr1[i++];
            }
            while (j < n) {
                arr3[k++] = arr2[j++];
            }
        }
        return arr3[k - 1];

    }

    public static int kthEleBetter(int arr1[], int arr2[], int k) {
        int n = arr1.length;
        int m = arr2.length;

        int count = 0;
        int i = 0, j = 0;
        while (i < n && j < m) {
            int current;
            if (arr1[i] < arr2[j]) {
                current = arr1[i++];
            } else {
                current = arr2[j++];

            }
            count++;
            if (count == k) {
                return current;
            }
        }
        while (i < n) {
            count++;
            if (count == k) {
                return arr1[i];

            }
            i++;
        }
        while (j < m) {
            count++;
            if (count == k) {
                return arr2[j];

            }
            j++;

        }
        return -1;
    }

    public static int kthEleOptimal(int arr1[], int arr2[], int k) {
        int m = arr1.length;
        int n = arr2.length;
        if (m > n) {
            return kthEleOptimal(arr2, arr1, k);
        }
        int low = Math.max(0, k - n);
        int high = Math.min(k, m);
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MAX_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if (mid1 < m) {
                r1 = arr1[mid1];

            }
            if (mid2 < n) {
                r2 = arr2[mid2];

            }
            if (mid1 - 1 >= 0) {
                l1 = arr1[mid1 - 1];
            }
            if (mid2 - 1 >= 0) {
                l2 = arr2[mid2 - 1];
            }
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);

            } else if (l1 > r2) {
                high = mid1 - 1;

            } else {
                low = mid1 + 1;

            }

        }
        return 0;

    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 6, 7, 9 };
        int[] arr2 = { 1, 4, 8, 10 };
        int k = 5;

        int result = kthEle(arr1, arr2, k);
        System.out.println("The " + k + "-th element is: " + result);

        int result1 = kthEle(arr1, arr2, k);
        System.out.println("The " + k + "-th (Brute Force) element is: " + result1);

        int result2 = kthEle(arr1, arr2, k);
        System.out.println("The " + k + "-th (Better Approach) element is: " + result2);
        int result3 = kthEle(arr1, arr2, k);
        System.out.println("The " + k + "-th (Optimal Approach) element is: " + result3);
    }

}
