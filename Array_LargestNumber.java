//import java.util.*;

public class Array_LargestNumber {
    public static int getLargestNumber(int numbers[]) {
        int Largest = Integer.MIN_VALUE;
        int Smallest = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (Largest < numbers[i]) {
                Largest = numbers[i];
            }
            if (Smallest > numbers[i]) {
                Smallest = numbers[i];
            }

        }
        System.out.println("SMALLEST NUMBER IS :" + Smallest);
        return Largest;

    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("ENTER THE SIZE OF THE ELEMENTS OF AN ARRAY:");
        // int arr_Size = sc.nextInt();
        // int numbers[] = new int[arr_Size];
        // System.out.println("ENTER THE SIZE OF THE ELEMENTS OF AN ARRAY:");
        // for (int i = 1; i <= arr_Size; i++) {

        // numbers[i] = sc.nextInt();
        // }
        int numbers[] = { 5, 6, 7, 8, 9, 2, 1, 3 };
        System.out.println("THE LARGEST NUMBER IS:" + getLargestNumber(numbers));
        // sc.close();
    }

}
