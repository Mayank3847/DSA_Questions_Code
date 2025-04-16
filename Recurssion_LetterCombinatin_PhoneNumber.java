import java.util.*;

public class Recurssion_LetterCombinatin_PhoneNumber {
    public static void getAllCombination(String s, int index, String output, String[] mapping, List<String> ans) {
        if (index >= s.length()) {
            ans.add(output);
            return;
        }
        int number = s.charAt(index) - '0';
        String value = mapping[number];
        for (int i = 0; i < value.length(); i++) {
            output += value.charAt(i);
            getAllCombination(s, index + 1, output, mapping, ans);
            output = output.substring(0, output.length() - 1);
        }

    }

    public static List<String> letterCombinations(String s) {
        String output = "";

        List<String> ans = new ArrayList<>();
        if (s.length() == 0 || s.isEmpty()) {
            return ans;
        }
        String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        getAllCombination(s, 0, output, mapping, ans);
        return ans;
    }

    public static void main(String[] args) {
        String digits = "67";

        // Get all letter combinations
        List<String> result = letterCombinations(digits);

        // Print the result
        System.out.println("Letter combinations for digits \"" + digits + "\":");
        System.out.println(result);
    }

}
