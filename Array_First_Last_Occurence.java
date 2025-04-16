public class Array_First_Last_Occurence {
    public static int firstOccurence(int arr[], int key) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int firstOccurenceOptimal(int arr[], int key) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static int lastOccurence(int arr[], int key) {
        int n = arr.length;
        int result = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == key) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static int lastOccurenceOptimal(int arr[], int key) {
        int n=arr.length;
        int start = 0;
        int end = n-1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                result = mid;
                start = mid + 1;

            } else if (arr[mid] < key) {
                start = mid + 1;

            } else {
                end = mid - 1;

            }

        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 13, 23, 13, 10 };
        int key = 13;
        System.out.println("First occurence(at optimal approach ) at index " + firstOccurenceOptimal(arr, key));
        System.out.println("First occurence at index " + firstOccurence(arr, key));
        System.out.println("Last occurence(at optimal approach ) at index " + lastOccurenceOptimal(arr, key));
        System.out.println("Last Occurrence AtIndex " + lastOccurence(arr, key));

    }

}
