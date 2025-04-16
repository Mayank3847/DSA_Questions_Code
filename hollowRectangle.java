import java.util.*;

public class hollowRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER ");
        int n = sc.nextInt();
        int number_of_lines = 1;
        int st = n;
        int sp = n - 2;
        while (number_of_lines <= n - 1) {
            if (number_of_lines == 1 || number_of_lines == n - 1) {

                for (int i = 0; i < st; i++) {
                    System.out.print("* ");
                }
            } else {
                // print stars
                System.out.print("* ");
                // print space

                for (int i = 0; i < sp; i++) {
                    System.out.print("  ");

                }
                // print one stars
                System.out.print("* ");
            }
            System.out.println();
            number_of_lines++;

        }
        sc.close();
    }
}
