import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class triplets_Example {

    public List<List<Integer>> threeSum(int nums[]) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<Integer>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);

                        triplet.add(nums[k]);
                        result.add(triplet);

                    }

                }
            }
        }
        result = new ArrayList<List<Integer>>(new LinkedHashSet<List<Integer>>(result));
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        triplets_Example solution = new triplets_Example();
        List<List<Integer>> triplets = solution.threeSum(nums);

        // Print the triplets
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }
}