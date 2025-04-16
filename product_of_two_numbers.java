import java.util.*;

public class product_of_two_numbers {
    public static int multiply(int a, int b) {
        int product = a * b;
        return product;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE FIRST NUMBER");
        int a = sc.nextInt();
        System.out.println("ENTER THE SECOND NUMBER");
        int b = sc.nextInt();
        int prod = multiply(a, b);
        System.out.println("THE PRODUCT OF " + a + " and " + b + " is:" + prod);
        sc.close();
    }

}
