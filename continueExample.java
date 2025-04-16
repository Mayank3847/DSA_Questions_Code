import java.util.*;

public class continueExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("ENTER THE NUMBER:");
            int n = sc.nextInt();
            if (n % 10 == 0 || n % 5 == 0) {
                System.out.println("I DONT KNOW ANYTHING");
                continue;
            }
            System.out.println(n);

            sc.close();
        } while (true);

    }

}
