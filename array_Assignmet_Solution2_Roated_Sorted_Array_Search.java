public class array_Assignmet_Solution2_Roated_Sorted_Array_Search {
    public static int search(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // Check which side of the array is sorted
            if (nums[left] <= nums[mid]) {// Left side is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    // Search left side
                    right = mid - 1;
                } else {
                    // Search right side
                    left = mid + 1;
                }
 
                // Right side is sorted
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    // Search right side
                    left = mid + 1;

                } else {
                    // Search left side
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println("Index of target: " + search(nums, target));
    }
}
