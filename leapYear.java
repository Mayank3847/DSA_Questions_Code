import java.util.*;

class leapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE YEAR");
        int year = sc.nextInt();
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("LEAP YEAR");

        } else {
            System.out.println("NON LEAP YEAR");
        }
        sc.close();
    }
}
