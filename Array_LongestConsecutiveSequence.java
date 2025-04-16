import java.util.*;

import java.util.Arrays;

public class Array_LongestConsecutiveSequence {
    public static boolean linearSearch(int arr[], int num) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    public static int longestConsecutive(int arr[]) {
        int n = arr.length;
        int longest = 1;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int count = 1;
            while (linearSearch(arr, x + 1)) {
                x += 1;
                count += 1;
            }
            longest = Math.max(longest, count);

        }

        return longest;
    }

    public static int longestConsecutiveBetter(int arr[]) {
        int n = arr.length;
        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;
        int longest = 1;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] - 1 == lastSmaller) {
                count += 1;
                lastSmaller = arr[i];
            } else if (arr[i] != lastSmaller) {
                count = 1;
                 lastSmaller=arr[i];
            }
            longest = Math.max(count, longest);

        }
        return longest;
    }





    public static int longestConsecutiveOptimal(int arr[]){
        int n=arr.length;
        if(n==0){
            return 0;
        }
        int longest=1;
    Set<Integer>set=new HashSet<>();
    for(int i =0;i<n;i++){
        set.add(arr[i]);

    }
    for(int it:set){
        if(!set.contains(it-1)){
            int count=1;
            int x=it;
            while(set.contains(x+1)){
                x=x+1;
                count=count+1;

            }
            longest=Math.max(longest,count );

        }

    }
    return longest;

    }

    public static void main(String[] args) {
        int arr[] = { 100, 200, 1, 2, 3, 4 };
        int ans = longestConsecutive(arr);
        int result = longestConsecutiveBetter(arr);
        int result1=longestConsecutiveOptimal(arr);
        System.out.println("Longest Consecutive Sequence -> " + ans);
        System.out.println("Longest Consecutive Sequence  By Better Solution -> " + result);
        System.out.println("Longest Consecutive Sequence  By Optimal Solution -> " + result1);
    }

}