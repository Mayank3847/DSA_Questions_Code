import java.util.*;

public class prime_Number_in_Range {
    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;

            }

        }
        return true;
    }

    public static void prime_in_Range(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }

        }
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER n:");
        int n = sc.nextInt();
        prime_in_Range(n);
        sc.close();
    }

}
