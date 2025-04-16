import java.util.*;

public class increasing_Order_Recurrsion {
    public static void printIncreasing(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printIncreasing(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER:");
        int n = sc.nextInt();
        printIncreasing(n);
        sc.close();
    }
}
