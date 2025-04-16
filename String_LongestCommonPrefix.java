import java.util.*;

public class String_LongestCommonPrefix {
    public static String longestCommonPrefix(String[] str) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(str);
        char[] first = str[0].toCharArray();
        char[] last = str[str.length - 1].toCharArray();
        for (int i = 0; i < first.length; i++) {
            if (first[i] != last[i]) {
                break;
            }
            result.append(first[i]);
        }

        return result.toString();
    }

    public static String longestCommonPrefixOptimized(String[] str) {
        if (str == null || str.length == 0) {
            return "";

        }
        String prefix = str[0];
        for (int i = 1; i < str.length; i++) {
            while (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
if(prefix.isEmpty()){
    return "";
}
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] str = { "flower", "flight", "flow" };
        String result = longestCommonPrefix(str);
        System.out.println("The Longest common prefix : " + result);
        String result1 = longestCommonPrefixOptimized(str);
        System.out.println("The Longest common prefix : " + result1);
    }
}
