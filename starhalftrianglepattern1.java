import java.util.*;

public class starhalftrianglepattern1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER:");
        int n = sc.nextInt();
        int st = 1;
        int sp = n - 1;
        int number_of_lines = 1;
        while (number_of_lines <= n) {
            // print spaces
            for (int i = 0; i < sp; i++) {
                System.out.print("  ");

            }
            for (int j = 0; j < st; j++) {
                System.out.print("* ");
            }
            sp--;
            System.out.println();
            st++;
            // sp++;
            number_of_lines++;
        }
        sc.close();
    }
}
