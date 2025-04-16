import java.util.*;

public class Recurssion_Power_Set_Possible_Subsequence {
    public static List<String> possibleSubsequences(int index, String s, String f) {
        List<String> list = new ArrayList<>();
        if (index == s.length()) {
            list.add(f);
            return list;
        }
        list.addAll(possibleSubsequences(index + 1, s, f + s.charAt(index)));
        list.addAll(possibleSubsequences(index + 1, s, f));
        return list;

    }

    public static void main(String[] args) {
        String s = "abc";
        List<String> subsequences = possibleSubsequences(0, s, "");

        System.out.println("All possible subsequences are: " + subsequences);
    }

}
