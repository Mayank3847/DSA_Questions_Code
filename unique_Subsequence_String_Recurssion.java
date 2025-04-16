import java.util.*;

public class unique_Subsequence_String_Recurssion {
    public static void subsequences_unique(String str, int index, String newString, HashSet<String> set) {
        if (index == str.length()) {
            if (set.contains(newString)) {
                return;
            } else {
                System.out.println(newString);
                set.add(newString);
                return;
            }

        }
        char currentChar = str.charAt(index);
        subsequences_unique(str, index + 1, newString + currentChar, set);
        subsequences_unique(str, index + 1, newString, set);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER YOUR STRING: ");
        String str = sc.nextLine();
        HashSet<String> set = new HashSet<>();
        subsequences_unique(str, 0, " ", set);
        System.out.println("Total number of unique subsequences: " + set.size());
        // System.out.println("Total number of unique subsequences: " + set.size());
        sc.close();
    }

}
