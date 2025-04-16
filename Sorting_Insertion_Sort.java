import java.util.*;

public class Sorting_Insertion_Sort {
    public static void InsertionSort(int[] arr, int size) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int previous = i - 1;
            // finding the correct position where to insert element
            while (previous >= 0 && arr[previous] > current) {
                arr[previous + 1] = arr[previous];
                previous--;
            }
            // insertion
            arr[previous + 1] = current;

        }
    }

    public static void printArray(int arr[]) {
        System.out.println("Sorted Array!---");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE SIZE OF THE ELEMENT:");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter " + size + " elements for the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        InsertionSort(arr, size);
        printArray(arr);
        sc.close();
    }
}
