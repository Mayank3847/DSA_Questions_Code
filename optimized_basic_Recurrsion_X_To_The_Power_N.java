
/**
 * optimized_basic_Recurrsion_X_To_The_Power_N
 */
import java.util.*;

public class optimized_basic_Recurrsion_X_To_The_Power_N {

    public static int optimizedPower(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPower = optimizedPower(a, n / 2);
        int halfPowerSquare = halfPower * halfPower;
        if (n % 2 != 0) {
            halfPowerSquare = a * halfPowerSquare;

        }
        return halfPowerSquare;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER THE X");
        int a = sc.nextInt();
        System.out.println("ENTER THE N");
        int n = sc.nextInt();
        System.out.println("Solution:" + optimizedPower(a, n));
        sc.close();
    }
}
