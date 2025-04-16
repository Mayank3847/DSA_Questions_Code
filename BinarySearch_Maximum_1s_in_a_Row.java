public class BinarySearch_Maximum_1s_in_a_Row {

    public static int maximum1s(int arr[][], int n, int m) {
        int maxCnt = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int cntOnes = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    cntOnes++;
                }
            }
            if (cntOnes > maxCnt) {
                maxCnt = cntOnes;
                index = i;
            }
        }
        return index;
    }

    public static int lowerBound(int arr[], int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans=n;
        while (low <= high) {
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;

            }else{
                low=mid+1;
            }

        }
        return ans;
    }
    public static int maximum1sOptimal(int arr[][],int n,int m){
        int maxCnt=0;
        int index=-1;
        for(int i =0;i<n;i++){
            int cntOnes=m-lowerBound(arr[i], m, 1);
            if(cntOnes>maxCnt){
                maxCnt=cntOnes;
                index=i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int arr[][] = { { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 1, 1 },
                { 1, 1, 0, 0 } };
        int n = 4, m = 4;
        int result = maximum1s(arr, n, m);
        if (result != -1) {
            System.out.println("Row with maximum number of 1's: " + result);
        } else {
            System.out.println("No 1's found in the matrix.");
        }
        int result1 = maximum1sOptimal(arr, n, m);
        if (result != -1) {
            System.out.println("Row with maximum number of 1's (Optimal Approach) : " + result1);
        } else {
            System.out.println("No 1's found in the matrix.");
        }
    }
}