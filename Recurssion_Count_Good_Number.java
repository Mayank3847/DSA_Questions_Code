import java.util.Scanner;

public class Recurssion_Count_Good_Number {
    static int MOD = 1_000_000_007;

    public static int countGoodNumber(long n) {
        long odd = n / 2;
        long even = (n + 1) / 2;
        return (int) (pow(5, even) * pow(4, odd) % MOD);

    }

    public static long pow(long x, long n) {
        if (n == 0) {
            return 1;
        }
        long temp = pow(x, n / 2);
        if (n % 2 == 0) {
            return (temp * temp) % MOD;
        }else{
            return (x*temp*temp)%MOD;
        }

    }
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the value of n: ");
        long n = scanner.nextLong();
        
        int result = countGoodNumber(n);
        System.out.println("Count of good numbers: " + result);
        
        scanner.close();
    }
}
