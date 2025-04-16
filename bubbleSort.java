import java.util.*;

public class bubbleSort {
    public static void bubbleSortBasics(int arr[], int size) {
        for (int turns = 0; turns < arr.length; turns++) {
            for (int j = 0; j < arr.length - 1 - turns; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int arr[]) {
        System.out.print("SORTED ARRAY: ");
        for (int i = 0; i < arr.length; i++) {
            // System.out.print("SORTED ARRAY!");
            System.out.print(+arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the size of the array
        System.out.println("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Create an array of the specified size
        int[] arr = new int[size];

        // Ask the user to input elements for the array
        System.out.println("Enter " + size + " elements for the array:");

        // Loop to read input for each element of the array
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        bubbleSortBasics(arr, size);
        printArray(arr);
        scanner.close();

    }

}
