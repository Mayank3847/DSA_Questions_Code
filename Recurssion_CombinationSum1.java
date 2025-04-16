import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Recurssion_CombinationSum1 {

    public static void getAllCombinationI(int arr[], int idx, int target, List<Integer> ans,
            List<List<Integer>> result) {
         

        int n = arr.length;
        if (target == 0) {
            // if(!set.contains(ans)){

            result.add(new ArrayList<>(ans));
            // set.add(ans);
            // }
            return;
        }
        if (idx == n || target < 0) {
            return;
        }
        ans.add(arr[idx]);

        // Multiple time allowed
        getAllCombinationI(arr, idx, target - arr[idx], ans, result);
        // Exclusion of number
        ans.remove(ans.size() - 1);
        getAllCombinationI(arr, idx + 1, target, ans, result);

    }

    public static List<List<Integer>> combinationSumI(int[] candidates, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates); 
        getAllCombinationI(candidates, 0, target, list, finalList);
        return finalList;

    }



    public static void getAllCombinationII(int arr[], int idx, int target, List<Integer> ans,
            List<List<Integer>> result) {
         

        int n = arr.length;
        if (target == 0) {
            // if(!set.contains(ans)){

            result.add(new ArrayList<>(ans));
            // set.add(ans);
            // }
            return;
        }
        if (idx == n || target < 0) {
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            
            if (i > idx && arr[i] == arr[i - 1]) {
                continue;
            }
            ans.add(arr[i]);
            getAllCombinationII(arr, i + 1, target - arr[i], ans, result);
            ans.remove(ans.size() - 1);
        }
    }
    public static List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates); 
     
        getAllCombinationII(candidates, 0, target, list, finalList);
        return finalList;

    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> solution1 = combinationSumI(arr, target);
        System.out.println(solution1);
        List<List<Integer>> solution2 = combinationSumII(arr, target);
        System.out.println(solution2);
    }

}
