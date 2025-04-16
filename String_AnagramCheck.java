import java.util.*;

public class String_AnagramCheck {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return true;
        }
        String str = s.toLowerCase();
        String str1 = t.toLowerCase();
        char[] arr = str.toCharArray();
        char[] arr1 = str1.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(arr1);
        return Arrays.equals(arr, arr1);
    }

    public static boolean isAnagramOptimized(String s, String t) {
        if (s.length() != t.length()) {
            return false;

        }
        char[] charCount = new char[26];
        String str = s.toLowerCase();
        String str1 = t.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i) - 'a']++;
            charCount[str1.charAt(i) - 'a']--;

        }
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        // Check if the strings are anagrams
        if (isAnagram(s, t)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String t1 = sc.nextLine();
        if (isAnagramOptimized(s1, t1)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
        sc.close();
    }
}
