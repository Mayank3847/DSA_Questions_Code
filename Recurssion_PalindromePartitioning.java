import java.util.*;

public class Recurssion_PalindromePartitioning {
    public static List<List<String>> palindromePartitioning(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        getAllPartition(s, 0, result, ans);
        return result;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false; 
            }
        }
        return true;
    }

    public static void  getAllPartition(String s, int index, List<List<String>> result, List<String> ans) {
        if (index == s.length()) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                ans.add(s.substring(index, i + 1));
                getAllPartition(s,i+1,result,ans);
                ans.remove(ans.size()-1);

            }
        }
    }
    public static void main(String[] args) {
        String s = "aabb";
        List < List < String >> ans = palindromePartitioning(s);
        // int n = ans.size();
        System.out.println("The Palindromic partitions are :-");
        System.out.print(" [ ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " | ");
            }
            System.out.print("] ");
        }
        System.out.print("]");
    }

}
