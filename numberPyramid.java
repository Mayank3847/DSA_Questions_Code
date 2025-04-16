import java.util.*;

public class numberPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER ");
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < num - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                if (j % 2 == 0) {
                    System.out.print(i);

                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
        sc.close();
    }
}