
// import java.util.*;
public class Array_Kadanes_Print {
    public static int kadanes(int arr[]) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;
        for (int i = 0; i < n; i++) {
            if (sum == 0) {
                start = i;

            }
            sum += arr[i];
            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.print("THE SUBARRAY IS -> [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ,");
        }
        System.out.print("]\n");
        return maxi;
    }

    public static void main(String[] args) {

        int arr[]={ -2, 1, -3, 4, -1, 2, 1, -5, 4};
        // array_Kadanes_Print sol=new array_Kadanes_Print();

        int maxSum=kadanes(arr);
        System.out.println("Maximum Sum "+maxSum);
    }

}
