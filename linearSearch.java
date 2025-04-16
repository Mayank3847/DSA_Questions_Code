import java.util.*;

public class linearSearch {
    public static int LinearSearch(int numbers[], int key) {
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (numbers[i] == key) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE KEY NUMBER WHICH IS TO BE FOUND:");

        int key = sc.nextInt();
        int numbers[] = { 2, 4, 6, 8, 10, 12, 15, 14, 20 };
        int index = LinearSearch(numbers, key);
        if (index == -1) {
            System.out.println(key + " : NOT FOUND");
        } else {
            System.out.println("KEY IS AT INDEX:" + index);
        }
        sc.close();

    }

}
