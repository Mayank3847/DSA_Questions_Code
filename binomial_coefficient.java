
import java.util.*;

public class binomial_coefficient {
    public static int factorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;

    }

    public static int binomialCoefficient(int n, int r) {
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nmr = factorial(n - r);// nmr=n-r(n minus r)
        int binomialCoefficient = fact_n / (fact_r * fact_nmr);
        return binomialCoefficient;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER n:");
        int n = sc.nextInt();

        System.out.println("ENTER THE NUMBER r:");
        int r = sc.nextInt();
        System.out.println(binomialCoefficient(n, r));
        sc.close();
    }
}
