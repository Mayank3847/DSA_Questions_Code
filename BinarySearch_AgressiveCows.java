import java.util.Arrays;

class BinarySearch_AgressiveCows {

    public static boolean canWePlace(int[] arr, int dist, int cows) {
        int n = arr.length;
        int cntCows = 1;
        int last = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] - last >= dist) {
                cntCows++;
                last = arr[i];

            }
            if (cntCows >= cows) {
                return true;
            } 
        }
        return false;

    }
    public static int agressiveCows(int arr[],int k ){
        int n = arr.length;
        Arrays.sort(arr);
        int limit=arr[n-1]-arr[0];
        for(int i =1;i<=limit;i++){
            if(canWePlace(arr, i, k)==false){
                return (i-1);

            }
        }
        return limit;
    }
    public static boolean canWePlaceOptimal(int[] arr, int dist, int cows) {
        int n = arr.length;
        int cntCows = 1;
        int last = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] - last >= dist) {
                cntCows++;
                last = arr[i];

            }
            if (cntCows >= cows) {
                return true;
            } 
        }
        return false;

    }
    public static int agressiveCowsOptimal(int arr[],int dist,int k ){
        int n =arr.length;
        Arrays.sort(arr);
        int low=1;
        int high=arr[n-1]-arr[0];
        while(low<=high){
            int mid=(low+high)/2;
            if(canWePlace(arr, mid, k)==true){
                low=mid+1;
            }else{
                high=mid-1;
            }

        }
        return high;
    }
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = agressiveCows(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);
        int ans1 = agressiveCows(stalls, k);
        System.out.println("The maximum possible minimum distance (Optimal Approach) is: " + ans1);
   
    }

}