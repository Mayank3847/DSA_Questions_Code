import java.util.*;

public class Markmoderator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of students
        System.out.print("Enter the number of students: ");
        int N = scanner.nextInt();

        // Read the marks of the students
        int[] studentMarks = new int[N];
        System.out.println("Enter the marks of the students:");
        for (int i = 0; i < N; i++) {
            studentMarks[i] = scanner.nextInt();
        }

        // Moderate and print the marks
        System.out.println("Moderated marks:");
        for (int i = 0; i < N; i++) {
            int moderatedMark = moderateMarks(studentMarks[i]);
            System.out.println(moderatedMark);
        }

        scanner.close();
    }

    public static int moderateMarks(int marks) {
        if (marks < 48) {
            // Student fails, no rounding
            return marks;
        } else if (marks > 95) {
            // Marks capped to 100 if greater than 95
            return 100;
        } else {
            // Round to the next multiple of 5 if within 2 marks
            int remainder = marks % 5;
            if (remainder >= 2) {
                return marks + (5 - remainder);
            } else {
                return marks;
            }
        }
    }
}
