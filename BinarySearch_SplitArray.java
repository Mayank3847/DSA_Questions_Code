public class BinarySearch_SplitArray {
    public static int countNumber(int arr[],int x){
        int n= arr.length;
        int cnt=1;
        int currSum=0;
        for(int i =0;i<n;i++){
            if(currSum+arr[i]<=x){
                currSum+=arr[i];

            }else{
                cnt++;
                currSum=arr[i];
            }
        }
        return cnt;
    }
    public static int getSumSplitArray(int arr[],int k){
        int n = arr.length;
        if(k>n){
            return -1;
        }
        int low=arr[0];
        int high=0;
        for(int i =0;i<n;i++){
            low=Math.max(arr[i],low);
            high+=arr[i];
        }
        for(int i =low;i<=high;i++){
            if(countNumber(arr, i)==k){
                return i;
            }
        }
        return low;

    }
    public static int getSumSplitArrayOptimal(int arr[],int k){
        int n = arr.length;
        if(k>n){
            return -1;
        }
        int low=arr[0];
        int high=0;
        for(int i =0;i<n;i++){
            low=Math.max(arr[i],low);
            high+=arr[i];
        }
        while(low<=high){
            int mid=(low+high)/2;
            if(countNumber(arr, mid)>k){
                low=mid+1;
            }else{
                high=mid-1;

            }

        }
        return high;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int k =3;
        int ans=getSumSplitArray(arr, k);
        System.out.println("The minimized largest sum of the split array : "+ans);
        int ans1=getSumSplitArray(arr, k);
        System.out.println("The minimized largest sum of the split array (Optimized Approach): "+ans1);
    }
}
