import java.util.*;
public class Array_NumberAppearOnce {
    public static int numberOnce(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int nums = arr[i];
            int count = 0;
            for (int j = 0; i < n; j++) {
                if (arr[j] == nums) {
                    count++;

                }
                if (count == 1) {
                    return nums;
                }
            }
        }
        return -1;
    }



    //for better approach in number Once 
    public static int getSingleElementBetter(int arr[]){
        int n = arr.length;
        int maxi=arr[0];
        for(int i =0;i<n;i++){
            maxi=Math.max(maxi,arr[i]);
        }
        int hash[]=new int [maxi+1];
        for(int i =0;i<n;i++){
            hash[arr[i]]++;

        }
        for(int i =0;i<n;i++){
            if(hash[arr[i]]==1){
                return arr[i];

            }
        }
        return -1;
    }

    //for better approach2
    public static int getSingleElementBetter1(int arr[]){
        int n=arr.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i =0;i<n;i++){
            int value=map.getOrDefault(arr[i],0);
            map.put(arr[i],value+1);

        }
        for(Map.Entry<Integer,Integer>it:map.entrySet()){
            if(it.getValue()==1){
                return it.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 1, 2, 1, 2 };
        int result = numberOnce(arr);
        System.out.println("The number that appears once in the array is -> " + result);
        int result1=numberOnce(arr);
        System.out.println("The number that appears once in the array (Better Approach-1) is -> " + result1);
        int result2=getSingleElementBetter1(arr);
        System.out.println("The number that appears once in the array (Better Approach-2) is -> " + result2);



    }

}
