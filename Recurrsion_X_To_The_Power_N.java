//import java.util.*;

public class Recurrsion_X_To_The_Power_N {
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1);
    }

    public static double power_Optimized(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        if (x == -1 && n % 2 == 0) {
            return 1;
        }
        if (x == -1 && n % 2 != 0) {
            return -1;
        }
        long binForm = n;
        if (n < 0) {
            x = 1 / x;
            binForm = -binForm;
        }
        double ans = 1;

        while (binForm > 0) {
            if (binForm % 2 == 1) {
                ans *= x;

            }
            x *= x;
            binForm /= 2;
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println("Solution:" + power(5, 5));
        System.out.println("Solution:" + power_Optimized(5, -5));

        // sc.close();

    }

}
