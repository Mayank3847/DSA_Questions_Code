import java.util.*;

class calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER1:");
        int a = sc.nextInt();
        System.out.println("ENTER THE NUMBER2:");
        int b = sc.nextInt();
        System.out.println("ENTER THE OPERATOR:");
        char operators = sc.next().charAt(0);
        switch (operators) {
            case '+':
                System.out.println(a + b);
                break;

            case '*':
                System.out.println("THE PRODUCT OF NUMBER1 AND NUMBER2 IS :" + a * b);
                break;
            case '/':
                System.out.println("THE DIVISION OF A AND B IS :" + a / b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '%':
                System.out.println("THE MODULUS OF A AND B IS :" + a % b);
                break;
            default:
                System.out.println("THIS CALCULATOR IS NOT AS MUCH ADVANCED :");
        }
        sc.close();
    }
}
