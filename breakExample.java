import java.util.*;

public class breakExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("ENTER THE NUMBER");
            int n = sc.nextInt();
            if (n % 10 == 0 || n % 5 == 0) {
                System.out.println(n + " is multiple of 10 or 5");
                break;

            }
            System.out.println(n);

        } while (true);
        sc.close();
    }
}
