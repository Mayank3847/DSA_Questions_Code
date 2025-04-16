import java.util.*;

public class inverted_rotated_half_triangle_numbers {
    public static void invertedRotatedHalfTriangleNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER n:");
        int n = sc.nextInt();
        invertedRotatedHalfTriangleNumbers(n);
        sc.close();
    }

}
