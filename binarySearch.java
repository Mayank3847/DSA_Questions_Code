//import java.util.*;

public class binarySearch {
    public static int Binary_Search(int numbers[], int key) {
        int start = 0, end = numbers.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            // comparision krne k liye condition lgg rha h yahan

            if (numbers[mid] == key) {
                // found the key
                return mid;
            }
            if (numbers[mid] < key) {
                // move to right and search the key
                start = mid + 1;
            } else {
                // shift to left
                end = mid - 1;
            }

        }
        System.out.println(" key is not found");
        return -1;
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
        int key = 1;
        System.out.println("INDEX FOR " + key + " IS AT:" + Binary_Search(numbers, key));
        //sc.close();
    }
}
