import java.util.*;

public class fibonacci_Recurssion {
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int fibonacciN = fibonacci(n - 1) + fibonacci(n - 2);
        return fibonacciN;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER THE NUMBER:");
        int n = sc.nextInt();
        System.out.println("FIBONACCI OF " + n + " series is: " + fibonacci(n));
        sc.close();
    }

}
