public class Array_Minimum_In_SortedArray {
    public static int getMinimum(int arr[]) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);

        }
        return min;
    }

    public static int getMinimumOptimal(int arr[]) {

        int ans = Integer.MAX_VALUE, n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;

            }
            if(arr[low]<=arr[mid]){
                ans=Math.min(ans, arr[low]);
                low=mid+1;
            }
            else{
                ans=Math.min(ans,arr[mid]);
                high=mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 6, 5, 1, 2, 3,4 };
        System.out.println("Minimum in sorted Array : " + getMinimum(arr));
        System.out.println("Minimum in sorted Array in optimal solution : " + getMinimumOptimal(arr));

    }

}
