
public class Array_MinimumRotation_In_SortedArray {
    public static int minimumRotation(int arr[]) {
        int n = arr.length;
        int cnt = -1;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (ans > arr[i]) {
                ans = arr[i];
                cnt = i;
            }
        }
        return cnt;

    }
      public static int minimumRotationOptimal(int [] arr) {
        // Code here
          int n =arr.length;
      int low=0;
      int high=n-1;
      int ans=Integer.MAX_VALUE;
      int index=-1;
      while(low<=high){
          int mid=(low+high)/2;
          if(arr[low]<=arr[high]){
              if(arr[low]<ans){
                  index=low;
                  ans=arr[low];
                  
              }
              break;
          }
          if(arr[low]<=arr[mid]){
              if(arr[low]<ans){
                  index=low;
                  ans=arr[low];
                  
                  
              }
              low=mid+1;
              
          }else{
              if(arr[low]<ans){
                  index=mid;
                  ans=arr[mid];
              }
              high=mid-1;
              
          }
      }
      return index;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7,1,2,3 };
        System.out.println("The number of rotation in sorted array : " + minimumRotation(arr));
        System.out.println("The number of rotation in sorted array : " + minimumRotationOptimal(arr));

    }

}
