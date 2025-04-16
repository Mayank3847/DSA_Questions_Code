import java.util.*;

public class Recurssion_Better_String {

    public static HashSet<String> findDistinctSubsequences(String str, int index, String current, HashSet<String> set) {
        if (index == str.length()) {
            set.add(current);
            return set;
        }
        findDistinctSubsequences(str, index + 1, current + str.charAt(index), set);
        findDistinctSubsequences(str, index + 1, current, set);
        return set;

    }

    public static int countOfDistinctSubsequence(String str) {
        HashSet<String> set = new HashSet<>();
        findDistinctSubsequences(str, 0, "", set);
        return set.size();

    }

    public static String betterString(String str1, String str2) {
        int count1 = countOfDistinctSubsequence(str1);
        int count2 = countOfDistinctSubsequence(str2);
        if (count1 >= count2) {
            return str1;
        }
        return str2;

    }

    public static int countOfDistinctSubsequenceOptimized(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = str.length();
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            char ch = str.charAt(i-1);
            dp[i] = 2 * dp[i - 1];
            if (map.containsKey(ch)) {
                int j = map.get(ch);
                dp[i] -= dp[j - 1];
            }
            map.put(ch, i);
        }
        return dp[n];
    }

    public static String betterStringOptimized(String str1, String str2) {
        int count1 = countOfDistinctSubsequenceOptimized(str1);
        int count2 = countOfDistinctSubsequenceOptimized(str2);
        if (count1 >= count2) {
            return str1;
        }
        return str2;

    }
 
    public static void main(String[] args) {
        String str1 = "rat";
        String str2 = "horse";
        System.out.println(betterString(str1, str2));
        System.out.println(betterStringOptimized(str1, str2));

    }

}
