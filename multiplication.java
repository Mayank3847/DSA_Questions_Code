import java.util.*;

class multiplication {
    public static void printMultiplicationTable(int number) {
        // System.out.println("ENTER THE NUMBER");

        // int n = sc.nextInt();

        for (int i = 1; i <= 10; i++) {

            System.out.println(number + " * " + i + " =" + number * i);

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER");

        int n = sc.nextInt();
        printMultiplicationTable(n);
        sc.close();

    }

}
