public class BinarySearch_KokoEatingBanana {

    public static int getMax(int arr[]) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);

        }
        return maxi;
    }

    public static int calculateTotalHours(int arr[], int hourly) {
        int totalH = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) arr[i] / (double) hourly);

        }
        return totalH;

    }

    public static int minimumRateToEatBananas(int[] arr, int h) {
        int maxi = getMax(arr);
        for (int i = 1; i <= maxi; i++) {
            int reqTime = calculateTotalHours(arr, i);
            if (reqTime <= h) {
                return i;
            }
        }
        return maxi;
    }

    // Optimal Approach----->>>
    public static int getMax1(int arr[]) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;

    }

    public static int calculateTotalHours1(int arr[], int hourly) {
        int n = arr.length;
        int totalH = 0;
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) arr[i] / (double) hourly);

        }
        return totalH;
    }

    public static int minimumRateToEatBananas1(int arr[], int h) {
        int low = 1;
        int high = getMax1(arr);
while(low<=high){
    int mid=(low+high)/2;
    int totalH=calculateTotalHours1(arr, mid);
    if(totalH<=h){
        high=mid-1;
    }else{
        low=mid+1;
    }

}
return low;
    }

    public static void main(String[] args) {
        int[] v = { 7, 15, 6, 3 };
        int h = 8;
        int ans = minimumRateToEatBananas(v, h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
        
        int ans1 = minimumRateToEatBananas1(v, h);
        System.out.println("Koko should eat at least (Optimal)" + ans1 + " bananas/hr.");
    }
}