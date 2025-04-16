import java.util.*;

public class Array_LongestSubArraySumAs_K {
    public static int subarraySum(int arr[], int K) {
        int n = arr.length;
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];

                }
                if (sum == K) {
                    len = Math.max(len, j - i + 1);

                }
            }
        }
        return len;
    }

    public static int subarraySumBruteForce(int arr[], int k) {
        int n = arr.length;
        int len = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;

    }

    // Better approach---
    public static int subArraySumBetterApproach(int arr[], int k) {
        int n = arr.length;
        Map<Integer, Integer> prefSum = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);

            }
             int rem = sum - k;
            if (prefSum.containsKey(rem)) {
                int len = i - prefSum.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if (!prefSum.containsKey(sum)) {
                prefSum.put(sum, i);

            }
        }
        return maxLen;
    }

    // optimal approach
    public static int subarraySumOptimal(int arr[], int k) {
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int maxLen = 0;
        int n = arr.length;
        while (right < n) {
            while (left <= right && sum > k) {
                sum = sum - arr[left];
                left++;

            }
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
            if (right < n) {
                sum += arr[right];

            }
        }

        return maxLen;

    }

    public static void main(String[] args) {
        int arr[] = { 1,-1,1};
        int K = 1;
        int result = subarraySum(arr, K);
        System.out.println("The Subarray Sum (BRUTE FORCE APPROACH) As " + K + " -> " + result);
        int result1 = subarraySumBruteForce(arr, K);
        System.out.println("The Subarray Sum (BRUTE FORCE APPROACH O(N2)) As " + K + " -> " + result1);
        int result2 = subarraySumBruteForce(arr, K);
        System.out.println("The Subarray Sum (Better Approach--(O(n))) As " + K + " -> " + result2);
        int result3 = subarraySumOptimal(arr, K);
        System.out.println("The Subarray Sum (Optimal Approach--(O(n))) As " + K + " -> " + result3);
    }
}
