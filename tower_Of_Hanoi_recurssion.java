import java.util.*;

public class tower_Of_Hanoi_recurssion {
    static int moveCounter = 0;

    public static void tower_Of_Hanoi(int n, String source, String helper, String destination) {
        if (n == 1) {
            moveCounter++;
            System.out.println("Transfer of " + n + " disk from " + source + " to " + destination);
            return;
        }
        tower_Of_Hanoi(n - 1, source, destination, helper);
        moveCounter++;
        System.out.println("Transfer of " + n + " disk from " + source + " to " + destination);

        tower_Of_Hanoi(n - 1, helper, source, destination);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER:");
        int n = sc.nextInt();
        moveCounter = 0;
        tower_Of_Hanoi(n, "Source", "Helper", "Destination");
        System.out.println("THE NUMBER OF MOVE OF DISKS :" + moveCounter);
        sc.close();
    }

}
