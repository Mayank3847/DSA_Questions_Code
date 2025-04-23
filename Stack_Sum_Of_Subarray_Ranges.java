// import java.util.*;

public class Stack_Sum_Of_Subarray_Ranges {
    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        long range = 0;

        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                range += (max - min);
            }
        }

        return range;
    }
    public static void main(String[] args) {
        int[] nums = {4, -2, -3, 4, 1};   

        long result = subArrayRanges(nums);

        System.out.println("Sum of all subarray ranges: " + result);
 
    }

    
}