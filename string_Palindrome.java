import java.util.*;

public class string_Palindrome {
    public static boolean printPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            int n = str.length();
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER YOUR STRING:");
        String str = sc.nextLine();
        System.out.println(printPalindrome(str));

        sc.close();
    }
}
