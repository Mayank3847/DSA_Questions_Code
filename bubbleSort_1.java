import java.util.*;

public class bubbleSort_1 {
    public static void bubbleSorting_Descending(int arr[]) {
        for (int turn = 0; turn < arr.length - 1; turn++) {
            for (int j = 0; j < arr.length - 1 - turn; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={3,6,2,1,8,7,4,5,3,1};
        System.out.println("ARRAY BEFORE SORTING:"+Arrays.toString(arr));
        bubbleSorting_Descending(arr);
        System.out.println("ARRAYS AFTER SORTING: "+Arrays.toString(arr));
    }

}
