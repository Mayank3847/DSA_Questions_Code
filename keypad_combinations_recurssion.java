
/**
 * keypad_combinations_recurssion
 */
import java.util.*;

public class keypad_combinations_recurssion {

    public static String[] keypad = { ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", " " };

    public static void keypad_combination(String str, int index, String combinations) {
        if (index == str.length()) {
            System.out.println(combinations);
            return;
        }
        char currentChar = str.charAt(index);
        String mapping = keypad[currentChar - '0'];
        for (int i = 0; i < mapping.length(); i++) {
            keypad_combination(str, index + 1, combinations + mapping.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER YOUR STRING:");
        String str = sc.nextLine();
        keypad_combination(str, 0, " ");
        sc.close();

    }
}