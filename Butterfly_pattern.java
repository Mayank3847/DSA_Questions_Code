import java.util.*;

public class Butterfly_pattern {
    public static void butterfly(int n) {
        // first half
        for (int i = 1; i <= n; i++) {
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // 2nd haf
        for (int i = n; i >= 1; i--) {
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER n:");
        int n = sc.nextInt();
        butterfly(n);
        sc.close();
    }

}
