public class String_LongestPalindromSubstring {

    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (ch1 != ch2) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String longestPallindrome(String s) {
        int n = s.length();
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    if ((j - i + 1) > max) {
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end+1);

    }
    public static void main(String[] args) {
        String  s = "abrbadaadab";
        String result=longestPallindrome(s);
        System.out.println(result);
    }
}