import java.util.*;

public class Stack_Number_Of_Greater_Element_To_The_Right {
    public static int[] greaterElementRight(int n, int arr[], int queries, int indices[]) {
        Stack<Integer> asc = new Stack<>();
        Stack<Integer> desc = new Stack<>();
        int ans[] = new int[queries];
        int v[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int ele = arr[i];
            while (!asc.isEmpty() && ele >= asc.peek()) {
                desc.push(asc.pop());
            }
            desc.push(ele);
            v[i] = asc.size();
            while (!desc.isEmpty()) {
                asc.push(desc.pop()); 
            }

        }
        for (int i = 0; i < queries; i++) {
            ans[i] = v[indices[i]];
        }
        return ans;
    }  

    public static int[] greaterElementRightOptimized(int n, int arr[], int queries, int indices[]) {
    int nge[]=new int [queries];
    for(int i =0;i<queries;i++){
        int index=indices[i];
        int cnt=0;
        for(int j = index+1;j<n;j++){
            if(arr[j]>arr[index]){
                cnt++;
            }
             
        }
        nge[i]=cnt;
    }
    return nge;
    }


    public static void main(String[] args) {
        int n = 5;
        int[] arr = { 3, 4, 9, 2, 7 };
        int queries = 3;
        int[] indices = { 0, 2, 4 };

        int[] result = greaterElementRight(n, arr, queries, indices);
        int[] result1 = greaterElementRight(n, arr, queries, indices);

        for (int res : result1) {
            System.out.print(res+" ");
        }
         for (int res : result) {
            System.out.print(res+" ");
        }
        
    }

}
