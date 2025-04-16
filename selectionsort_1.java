import java.util.*;

public class selectionsort_1 {
    public static void selectionSort_Descending(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if ((arr[j]) > arr[maxIndex]) {
                    maxIndex = j;

                }
            }
            int temp=arr[maxIndex];
            arr[maxIndex]=arr[i];
            arr[i]=temp;
        }
    }
    public static void main(String[] args) {
        int arr[]={3,6,2,1,8,7,4,5,3,1};
        System.out.println("ARRAY BEFORE SORTING:"+Arrays.toString(arr));
        selectionSort_Descending(arr);
        System.out.println("ARRAYS AFTER SORTING: "+Arrays.toString(arr));
    }
}
