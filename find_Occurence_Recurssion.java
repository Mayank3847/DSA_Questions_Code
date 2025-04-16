import java.util.Scanner;

/**
 * find_Occurence_Recurssion
 */
public class find_Occurence_Recurssion {
    public static int first = -1;
    public static int last = -1;

    public static void findOccurence(String str, int index, char element) {
        if (index == str.length()) {
            System.out.println("The first occurence is at index:" + first);
            System.out.println("The last occurence is at index:" + last);
            return;
        }
        char currentChar = str.charAt(index);
        if (currentChar == element) {
            if (first == -1) {
                first = index;
            } else {
                last = index;
            }

        }
        findOccurence(str, index + 1, element);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER YOUR STRING:  ");
        String str = sc.nextLine();
        System.out.println("ENTER THE CHARACTER TO FIND: ");
        char element = sc.next().charAt(0);
        findOccurence(str, 0, element);
        sc.close();
    }
}