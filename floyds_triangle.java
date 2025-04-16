import java.util.*;

public class floyds_triangle {
    public static void floydsTriangle(int n) {
        // outer loop
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            /* inner loop----how many times will the counter will be printed.... */
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER n:");
        int n = sc.nextInt();
        floydsTriangle(n);
        sc.close();
    }
}
