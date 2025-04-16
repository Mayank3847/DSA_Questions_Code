import java.util.*;
public class BinarySearch_AllocateMinimumPages {
    public static int countStudent(ArrayList<Integer>arr,int pages){
        int n = arr.size();
        int student=1;
        long studentPages=0;
        for(int i =0;i<n;i++){
            if(studentPages+arr.get(i)<=pages){
                studentPages+=arr.get(i);
            }else{
                student++;
                studentPages=arr.get(i);
            }
        }
        return student;
    }
    public static int minimumPages(ArrayList<Integer>arr,int n ,int m ){
        if(m>n){
            return -1;
        }
        int low=Collections.max(arr);
        int high=0;
        for(int  i =0;i<n;i++){
            high+=arr.get(i);

        }
        for(int pages=low;pages<=high;pages++){
            if(countStudent(arr, pages)==m){
                return pages;
            }
        }
        return low;
    }
    public static int minimumPagesOptimal(ArrayList<Integer>arr,int n,int m ){
        int low=Collections.max(arr);
        int high=0;
        for(int i =0;i<n;i++){
            high+=arr.get(i);

        }
        while(low<=high){
            int mid=(low+high)/2;
            if(countStudent(arr, mid)>m){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        int n = 4;
        int m = 2;
        int ans = minimumPages(arr, n, m);
        System.out.println("The answer is: " + ans);
        int ans1 = minimumPages(arr, n, m);
        System.out.println("The answer(Optimal Approach) is: " + ans1);
    }
    
}
