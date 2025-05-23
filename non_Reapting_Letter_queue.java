import java.util.Queue;
import java.util.LinkedList;

public class non_Reapting_Letter_queue {

    public static void nonRepeatingLetter(String str) {
        int freq[] = new int[26];
        Queue<Character> qu = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            qu.add(ch);
            freq[ch - 'a']++;
            while (!qu.isEmpty() && freq[qu.peek() - 'a'] > 1) {
                qu.remove();

            }
            if (qu.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(qu.peek() + " ");
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        String str = "aabccxb";
        nonRepeatingLetter(str);
    }
}
