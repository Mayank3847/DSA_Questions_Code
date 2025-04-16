import java.util.*;

public class decimal_to_binary {
    public static void decimalToBinary(int n) {
        int myNum = n;
        int pow = 0;
        int binNum = 0;
        while (n > 0) {
            int remainder = n % 2;
            binNum = binNum + (remainder * (int) Math.pow(10, pow));
            pow++;
            n = n / 2;

        }
        System.out.println("THE BINARY FORM OF " + myNum + ":=" + binNum);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER n:");
        int n = sc.nextInt();
        decimalToBinary(n);
        // System.out.println("THE DECIMAL FORM OF " + n + ":=" + binaryToDecimal(n));
        sc.close();
    }

}
