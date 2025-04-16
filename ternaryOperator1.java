import java.util.*;

public class ternaryOperator1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE MARKS:");
        int marks = sc.nextInt();
        String reportCard = marks >= 33 ? "pass" : "fail";
        System.out.println(reportCard);
        sc.close();
    }
}
