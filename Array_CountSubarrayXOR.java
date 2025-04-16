import java.util.*;
public class Array_CountSubarrayXOR {

    public static int subArrayXOR(int arr[], int target) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int ans = 0;
                for (int k = i; k <= j; k++) {
                    ans ^= arr[k];
                }
                if (ans == target) {
                    count++;
                }
            }
        }
        return count;
    }

    // For Better Approach
    public static int subArrayXORBetter(int arr[], int target) {
        int n = arr.length;
        int count = 0;
      for (int i = 0; i < n; i++) {
    int ans = 0; 
    for (int j = i; j < n; j++) {
        ans ^= arr[j];
        if (ans == target) {
            count++;
        }
    }
}
        return count;
    }


    //For Optimal Appproach--->
    public static int subArrayXOROptimal(int arr[],int target){
        int n =arr.length;
        int count =0;
        int xr=0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(xr, 0);
        for(int i =0;i<n;i++){
            xr^=arr[i];
            int x= xr^target;
            if(map.containsKey(xr)){
                map.put(xr,map.get(xr)+1);

            }else{
                map.put(xr,1);
            }
            if(map.containsKey(x)){
                count+=map.get(x);

            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        int target = 6;
        int ans = subArrayXOR(arr, target);
        System.out.println("The number of subarrays with XOR k is: " + ans);
        int ans1 = subArrayXORBetter(arr, target);
        System.out.println("The number of subarrays with XOR(Better Approach) k is: " + ans1);
        int ans2 = subArrayXORBetter(arr, target);
        System.out.println("The number of subarrays with XOR(Optimal Approach) k is: " + ans2);

    }
}