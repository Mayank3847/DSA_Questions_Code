//import java.util.Scanner;

import java.util.*;

public class inverted_rotated_half_triangle {
    public static void invertedRotatedHalfTriangle(int n) {
        for (int i = 0; i <= n; i++) {
            // spaces
            for (int j = 1; j <= n - i; j++) {
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
        invertedRotatedHalfTriangle(n);
        sc.close();

    }

}
