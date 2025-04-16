import java.util.*;

public class Anagram_Checker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE 1ST STRING:");
        String str1 = sc.nextLine();
        System.out.println("ENTER THE 2ND STRING:");
        String str = sc.nextLine();
        // convert string to lowercase ......why??? so that we dont have to check
        // lowercase or uppercase separately
        str1 = str1.toLowerCase();
        str = str.toLowerCase();
        // first check the length of the string
        if (str1.length() == str.length()) {
            // convert string into char array
            char[] str1charArray = str1.toCharArray();
            char[] strcharArray = str.toCharArray();
            // sort the char array-----
            Arrays.sort(str1charArray);
            Arrays.sort(strcharArray);
            // if the sorted char array are always same or identical then strings are
            // anagram of each other
            boolean result = Arrays.equals(str1charArray, strcharArray);
            if (result) {
                System.out.println(str1 + " and " + str + " are anagrams of each other !!");
            } else {
                System.out.println(str1 + " and " + str + " are NOT anagrams of each other !!");

            }

        } else {
            // case when length are not same !!
            System.out.println(str1 + " and " + str + " have not same length !!!!");
        }
        sc.close();
    }

}
