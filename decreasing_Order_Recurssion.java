import java.util.*;

public class decreasing_Order_Recurssion {
    public static void printDecreasingRec(int n) {
        if (n == 1) {
            System.out.println(n);
            return;

        }
        System.out.print(n + " ");
        printDecreasingRec(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" ENTER THE NUMBER ");
        int n = sc.nextInt();
        printDecreasingRec(n);
        sc.close();
    }

}
