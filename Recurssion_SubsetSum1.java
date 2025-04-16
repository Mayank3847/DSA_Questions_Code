import java.util.*;

public class Recurssion_SubsetSum1 {

    public static void subsetSumIHelper(int index, int sum, int arr[], int n, ArrayList<Integer> sumSubset) {
        if (index == n) {
            sumSubset.add(sum);
            return;

        }
        subsetSumIHelper(index + 1, sum + arr[index], arr, n, sumSubset);
        subsetSumIHelper(index + 1, sum, arr, n, sumSubset);

    }

    public static ArrayList<Integer> subsetSumI(int arr[], int N) {
        ArrayList<Integer> result = new ArrayList<>();
        subsetSumIHelper(0, 0, arr, N, result);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int arr[]={5,1,2};
        int N=3;
        ArrayList<Integer> result=subsetSumI(arr, N);
        System.out.println(result);
    }

}
