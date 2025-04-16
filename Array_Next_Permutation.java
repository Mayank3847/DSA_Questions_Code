 import java.util.Arrays;

public class Array_Next_Permutation {
    public  void nextPermutation(int []nums){
        int n =nums.length;
        int k=n-2;
        while(k>=0&&nums[k]>=nums[k+1]){
            k--;
        }
        if(k==-1){

            reverse(nums,0,n-1);
            return; 
        }
        int l=n-1;
        while(nums[l]<=nums[k]){
            l--;
        }
        swap(nums, k, l);
        reverse(nums, k+1, n-1);
    }
    public static void swap(int []nums,int i ,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void reverse(int []nums,int start,int end){
        while(start<end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Array_Next_Permutation sol = new Array_Next_Permutation();
        int[] nums = {1, 2, 3};
        
        
        System.out.println("Original array: " + Arrays.toString(nums));
        sol.nextPermutation(nums);
        System.out.println("Next permutation: " + Arrays.toString(nums));
    }
}
  