import java.util.*;

public class Recurssion_SubsetSum2 {

    public static void func(int[] nums, int index, List<Integer> ds, HashSet<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> sortedSubset = new ArrayList<>(ds);
            Collections.sort(sortedSubset);

            res.add(sortedSubset);
            return;
        }
        ds.add(nums[index]);
        func(nums, index + 1, ds, res);
        ds.remove(ds.size() - 1);
        func(nums, index + 1, ds, res);

    }

    public static List<List<Integer>> subsetWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> res = new HashSet<>();
        List<Integer> ds = new ArrayList<>();
        func(nums, 0, ds, res);
        ans.addAll(res);
        return ans;
    }

    public static void generateSubset(int nums[], int index, List<Integer> ans, List<List<Integer>> result) {
        result.add(new ArrayList<>(ans));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            ans.add(nums[i]);
            generateSubset(nums, i + 1, ans, result);
            ans.remove(ans.size() - 1);
        }

    }

    public static List<List<Integer>> subSetWithDupOptimized(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generateSubset(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 2 };
        List<List<Integer>> ans = subsetWithDup(nums);
        System.out.println("The unique subsets are:");
        List<List<Integer>> ans1 = subSetWithDupOptimized(nums);

        System.out.println(ans + " ");
        System.out.println(ans1 + " ");

    }
}
