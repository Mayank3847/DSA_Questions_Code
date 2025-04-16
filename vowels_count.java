import java.util.*;
public class vowels_count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE STRING:");
        String str = sc.nextLine();
        int count = countLowercaseVowels(str);
        System.out.println("THE NO.OF VOWELS IN THE STRINGS:" + count);

        sc.close();
    }

    public static int countLowercaseVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
                System.out.println("Vowel: " + ch + ", Position: " + (i + 1));
            }
        }
        // System.out.println("the vowels are:" );
        return count;
    }

}
