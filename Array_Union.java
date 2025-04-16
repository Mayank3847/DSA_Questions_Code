import java.util.*;

public class Array_Union {
    public static ArrayList<Integer> getUnion(int arr1[], int arr2[], int n, int m) {
        n = arr1.length;
        m = arr2.length;
        HashSet<Integer> set = new HashSet<>();
        // ArrayList<Integer>list=new ArrayList<>();
        // int union[]=new int [set.size()];
        for (int i = 0; i < n; i++) {
            set.add(arr1[i]);

        }
        for (int i = 0; i < m; i++) {
            set.add(arr2[i]);

        }
        return new ArrayList<>(set);
    }

    // TWO POINTER OPTIMAL APPROACH
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[],int n ,int m) {
       
       // int m = arr2.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> union = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < n) {
            if (union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }
        while (j < m) {
            if (union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);

            }
            j++;
        }
        return union;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 4, 5, 6 };
        int arr2[] = { 2, 3, 5, 7 };
        int n = arr1.length;
        int m = arr2.length;

        ArrayList<Integer> unionList = getUnion(arr1, arr2, n, m);
        System.out.println("Union of the arrays: " + unionList);
        ArrayList<Integer> Union = findUnion(arr1, arr2, n, m);
        System.out.print("Union of arr1 and arr2 is: ");
        for (int val : Union) {
            System.out.print(val + " ");
        }

    }

}
