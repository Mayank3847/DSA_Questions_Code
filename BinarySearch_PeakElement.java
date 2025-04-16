public class BinarySearch_PeakElement {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0; // Only one element, it's the peak
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;// last element is a peak
        }
        if (nums[0] > nums[1]) {
            return 0; // First element is a peak
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static int findPeakElementOptimal(int[] arr) {
        // code here
        int n = arr.length;
        if (n == 1) {
            return 0; // Only one element, it's the peak
        }
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }
        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= arr[mid + 1] && arr[mid] >= arr[mid - 1]) {
                return mid;
            }
            if (arr[mid] >= arr[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,1,3,5,6,4};
        int ans1 = findPeakElement(arr);
        System.out.println("The peak is at index: " + ans1);
        int ans2 = findPeakElementOptimal(arr);
        System.out.println("The peak is at index: " + ans2);

    }

}
