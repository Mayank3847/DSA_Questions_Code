import java.util.*;
class Array_LeaderArray
 {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer>result=new ArrayList<>();
        int n =arr.length;
        int max=arr[n-1];
        result.add(arr[n-1]);
        for(int i =n-2;i>=0;i--){
            if(arr[i]>=max){
                result.add(arr[i]);
                max=arr[i];
                
            }
        }
        Collections.reverse(result);
        return result;
    }


//brute force time complexity o(n2);

    public static ArrayList<Integer> printLeadersBruteForce(int[] arr, int n){
    
  ArrayList<Integer> ans= new ArrayList<>();
  
  for (int i = 0; i < n; i++) {
    boolean leader = true;

   
    for (int j = i + 1; j < n; j++)
      if (arr[j] > arr[i]) {
        leader = false;
        break;
      }
    if (leader)
    ans.add(arr[i]);

  }
  
  return ans;
   
}





    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
int n =arr.length;
        ArrayList<Integer> leaders = Array_LeaderArray.leaders(arr);

        System.out.println("Leaders in the array are: " + leaders);
        ArrayList<Integer> ans= printLeadersBruteForce(arr,n);
  System.out.print("Leaders in the array are: ");
  for (int i = 0; i < ans.size(); i++) {
    System.out.print(ans.get(i)+" ");
  }
    }
}