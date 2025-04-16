import java.util.*;

public class Prime_or_not {
    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % 2 == 0) {
                return false;
                
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER n:");
        int n = sc.nextInt();
        System.out.println(isPrime(n));
        sc.close();
    }
}
