import java.util.*;

public class sum_of_n_number_Recurssion {
    public static int sum_of_n_number(int n) {
        if (n == 0)

        {
            return 0;
        }
        int sumOfN = n + sum_of_n_number(n - 1);
        return sumOfN;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER THE NUMBER:");
        int n = sc.nextInt();
        System.out.println(" THE SUM OF " + n + " is: " + sum_of_n_number(n));
        sc.close();
    }
}
