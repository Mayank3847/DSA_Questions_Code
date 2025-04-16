import java.util.*;

public class costcalculationExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE COST OF PEN ");
        float a = sc.nextFloat();
        System.out.println("ENTER THE COST OF PENCIL ");
        float b = sc.nextFloat();
        System.out.println("ENTER THE COST ");
        float c = sc.nextFloat();
        float total = a + b + c;
        System.out.println("THE TOTAL COST OF PENCIL ,PEN AND ERASER IS:" + total);

        float newtotal = (total * 0.18f) + total;
        System.out.println("THE TOTAL PRICE INCLUDING 18% GST :" + newtotal);
        sc.close();
    }
}
