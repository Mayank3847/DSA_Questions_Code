import java.util.*;

public class binary_to_decimal {
    public static int binaryToDecimal(int n) {
        // int x= n;
        int pow = 0;
        int decNum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            decNum = decNum + (lastDigit * (int) Math.pow(2, pow));
            pow++;
            n = n / 10;

        }
        return decNum;
        // System.out.println("THE DECIMAL FORM OF " + n + ":=" + decNum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER n:");
        int n = sc.nextInt();
        binaryToDecimal(n);
        System.out.println("THE DECIMAL FORM OF " + n + ":=" + binaryToDecimal(n));
        sc.close();
    }

}
