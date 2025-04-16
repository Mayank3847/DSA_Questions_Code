public class Array_Count_Of_Occurrence {
    public static int countOccurrence(int arr[], int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                count++;

            }
        }
        return count;

    }

    // Count Occurence by optimal approach
    public static int firstOccurence(int arr[],int k ){
        int n = arr.length;
        int start=0;
        int end=n-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==k){
                ans=mid;
                end=mid-1;
                

            }else if( arr[mid]<k){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return ans;
    }
    public static int lastOccurence(int arr[],int k){
        int start =0;
        int n =arr.length;
        int end=n-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==k){
                ans=mid;
                start=mid+1;
            }else if(arr[mid]<k){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
    public static int[] firstAndLastOccurence(int arr[],int k){
        int first=firstOccurence(arr, k);
        if(first==-1){
            return new int[]{-1,-1};
        }
            int last=lastOccurence(arr, k);
            return new int[]{first,last};

    }
    public static int count(int arr[],int k ){
        int ans[]=firstAndLastOccurence(arr, k);
        if(ans[0]==-1){
            return 0;
        }
        return (ans[1]-ans[0]+1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 3, 3, 5, 5, 5, 5, 5, 9, 9, 11 };
        int k = 5;
        System.out.println("Count of occurrence of " + k + " is " + countOccurrence(arr, k));
        System.out.println("Count of occurrence(Optimal Approach) of " + k + " is " + count(arr, k));

    }

}
