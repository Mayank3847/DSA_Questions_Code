public class Array_Search_RotatedArray {
    public static int search(int arr[], int k) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) {
                return mid;

            }
            if (arr[start] <= arr[mid]) {
                if (arr[start] <= k && k < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;

                }
            } else {
                if (arr[mid] < k && arr[end] >= k) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static boolean isFound(int arr[], int k) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) {
                return true;
            }
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                   start= start+1;
                   end=end-1;
                   continue;
            }
            if(arr[start]<=arr[mid]){
                if(arr[start]<=k&k<=arr[mid]){
                    end=mid-1;

                }else{
                    start=mid+1;
                }
            }else{
                if(arr[mid]<=k&&k<=arr[end]){

                    start=mid+1;
                }else{
                    end=mid-1;   
                    
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int k = 4;
        System.out.println("Index of target: " + search(arr, k));
boolean ans=isFound(arr, k);
        System.out.println(ans);
        if(ans==true){
            System.out.println("Element exist in array ");
        }else{
            System.out.println("Element doesn't exist in array ");

        }
    }

}
