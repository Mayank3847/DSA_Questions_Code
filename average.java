import java.util.*;

public class average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER 1ST NUMBER :");
        int a = sc.nextInt();
        System.out.println("ENTER 2nd NUMBER :");
        int b = sc.nextInt();
        System.out.println("ENTER 3rd NUMBER :");
        int c = sc.nextInt();
        int average = (a + b + c) / 3;
        System.out.println("THE AVERAGE OF " + a + "," + b + "," + c + "is" + average);
        sc.close();
    }

}
