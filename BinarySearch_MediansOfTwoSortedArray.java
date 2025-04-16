import java.util.*;

public class BinarySearch_MediansOfTwoSortedArray {
    public static double median(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        List<Integer> arr3 = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                arr3.add(arr1[i++]);
                // i++;
            } else {
                arr3.add(arr2[j++]);
                // j++;

            }

        }
        while (i < n) {
            arr3.add((arr1[i++]));
            // i++;

        }
        while (j < m) {
            arr3.add((arr2[j++]));
            j++;
        }
        int k = n + m;
        // double median = 0;
        if (k % 2 == 1) {

            return arr3.get(k / 2);
        }
        double median = ((double) arr3.get(k / 2) + (double) arr3.get((k / 2) - 1));

        return median;

    }

    public static double medianBetter(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int totalLen = n + m;
        boolean isEven = totalLen % 2 == 0;
        int i = 0, j = 0, cnt = 0;
        int prev = 0, curr = 0;
        while (cnt <= totalLen / 2) {
            prev = curr;
            if (i < n && (j >= m || arr1[i] <= arr2[j])) {
                curr = arr1[i];
                i++;
            } else {
                curr = arr2[j];
                j++;
            }

            cnt++;
        }
        if (isEven) {
            return (prev + curr) / 2.0;
        }
        return curr;
    }

    public static double medianOptimal(int arr1[], int arr2[]) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        if (n1 > n2) {
            return median(arr2, arr1);

        }
        int n = n1 + n2;
        int left = (n1 + n2 + 1);
        int low = 0;
        int high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1;
            if (mid1 > 0) {
                l1 = arr1[mid1 - 1];

            } else {
                l1 = Integer.MIN_VALUE;
            }
            int l2;
            if (mid2 > 0) {
                l2 = arr2[mid2 - 1];

            } else {
                l2 = Integer.MIN_VALUE;

            }
            int r1;
            if (mid1 < n1) {
                r1 = arr1[mid1];

            } else {
                r1 = Integer.MAX_VALUE;
            }
            int r2;
            if (mid2 < n2) {
                r2 = arr2[mid2];
            } else {
                r2 = Integer.MAX_VALUE;

            }
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return Math.max(l1, l2);

                } else {
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
                }
            } else if (l1 > l2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 4, 7, 10, 12 };
        int[] arr2 = { 2, 3, 6, 15 };
        System.out.println("The median of two sorted arrays is " + median(arr1, arr2));
        System.out.println("The median of two sorted arrays is " + medianBetter(arr1, arr2));
        System.out.println("The median of two sorted arrays is " + medianOptimal(arr1, arr2));

    }

}
