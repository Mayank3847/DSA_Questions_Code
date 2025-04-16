import java.util.*;

public class Factorial_Recurssion {
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        int factN = n * fact(n - 1);
        return factN;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER:");
        int n = sc.nextInt();
        System.out.println("FACTORIAL OF " + n + " is: " + fact(n));
        sc.close();
    }
}
