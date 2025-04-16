import java.util.*;

public class factorial {
    public static int Factorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER:");
        int n = sc.nextInt();
        System.out.println("THE FACTORIAL OF " + n + " is : " + Factorial(n));
        sc.close();
    }

}
