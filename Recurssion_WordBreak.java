import java.util.*;

public class Recurssion_WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, new HashSet<>(wordDict), 0);
    }

    
    public static boolean wordBreakHelper(String s, Set<String> wordSet, int start) {
        if (start == s.length()) {
            return true;
        }
        for(int end=start+1;end<=s.length();end++){
            String prefix=s.substring(start, end);
            if(wordSet.contains(prefix)){
                if(wordBreakHelper(s, wordSet, end)==true){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "appleenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        String s1 = "leetcode";
    List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict)); 
        System.out.println(wordBreak(s1, wordDict1)); // Output: true
    }
}
