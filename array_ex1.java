import java.util.*;

public class array_ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many subject !");
        int mark = sc.nextInt();
        int[] marks = new int[mark];

        System.out.println("ENTER THE MARKS OF PHYSICS");
        marks[0] = sc.nextInt();
        System.out.println("ENTER THE MARKS OF CHEMISTRY");
        marks[1] = sc.nextInt();

        System.out.println("ENTER THE MARKS OF MATHS:");
        marks[2] = sc.nextInt();

        System.out.println("PHYSICS:" + marks[0]);
        System.out.println("CHEMISTRY:" + marks[1]);

        System.out.println("MATHS:" + marks[2]);
        marks[2] = marks[2] + 10;
        System.out.println("UPDATED MARKS OF MATHS :" + marks[2]);
        sc.close();

    }

}
