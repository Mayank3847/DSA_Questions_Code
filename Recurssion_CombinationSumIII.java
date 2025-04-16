import java.util.*;

public class Recurssion_CombinationSumIII {
    public static void getAllCombination(int start, int n, int k, ArrayList<ArrayList<Integer>> finalList,
            ArrayList<Integer> result) {
        if (result.size() == k && n == 0) {
            finalList.add(new ArrayList<>(result));
            return;
        }
        if (result.size() > k || n < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            result.add(i);
            getAllCombination(i + 1, n - i, k, finalList, result);
            result.remove(result.size() - 1);
        }

    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        getAllCombination(1, n, k, finalResult, result);
        return finalResult;                                                                                         
    }

    public static void main(String[] args) {
        int k = 3, n = 9;
        ArrayList<ArrayList<Integer>> combinations = combinationSum(n, k);
        System.out.println("Combinations: " + combinations);
    }

}
