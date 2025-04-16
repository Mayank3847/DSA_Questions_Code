import java.util.*;

public class printReverse_Recurssion {
    public static void printReverse(String str, int index) {
        if (index == 0) {
            System.out.println(str.charAt(index));
            return;
        }
        System.out.print((str.charAt(index)));
        printReverse(str, index - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your String :");
        String str = sc.nextLine();
        printReverse(str, str.length() - 1);
        sc.close();
    }

}
