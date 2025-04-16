//import java.util.*;
public class Pairs_of_an_array {
    public static void printsPairs(int numbers[]) {
        int totalPairs = 0;
        for (int i = 0; i < numbers.length; i++) {
            int arr = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                System.out.print(" (" + arr + "," + numbers[j] + ") ");
                totalPairs++;
            }
            System.out.println();
        }
        System.out.println("TOTAL NUMBERS OF PAIRS: " + totalPairs);
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        printsPairs(numbers);
    }

}
