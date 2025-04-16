import java.util.*;

public class Recurssion_Generate_Valid_Parenthesis {

    public static void generateValidParenthesis(int n, int open, int close, String s, List<String> result) {
        if (open == n && close == n) {
            result.add(s);
        }
        if (open < n) {
            generateValidParenthesis(n, open + 1, close, s + '{', result);
        }

        if (close < open) {
            generateValidParenthesis(n, open, close + 1, s + '}', result); 

        }
    }

    public static List<String> getAllValidParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n > 0) {
            generateValidParenthesis(n, 0, 0, "", ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 3;
        List<String> ans = getAllValidParenthesis(n);

        for (String str : ans) {
            System.out.println(str);
        }
    }
}