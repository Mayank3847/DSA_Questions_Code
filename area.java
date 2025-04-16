import java.util.*;

public class area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE SIDES OF A SQUARE :");
        int side = sc.nextInt();
        int area = side * side;
        System.out.println("THE AREA OF A SQUARE :" + area);
        sc.close();
    }

}
