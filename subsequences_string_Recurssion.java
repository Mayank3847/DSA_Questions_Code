import java.util.*;

public class subsequences_string_Recurssion {
    static int count = 0;

    public static void print_Subsequences(String str, int index, String newString) {
        if (index == str.length()) {
            System.out.println("The new String:" + newString);
            count++;
            return;
        }
        char currentChar = str.charAt(index);
        // to be in choice
        print_Subsequences(str, index + 1, newString + currentChar);
        // maya not continue to bh-e
        print_Subsequences(str, index + 1, newString);

    }

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("ENTER THE STRING");
        String str = Sc.nextLine();
        print_Subsequences(str, 0, " ");
        System.out.println("THE TOTAL NUMBER OF SUBSEQUENCES :" + count);
        Sc.close();
    }

}
