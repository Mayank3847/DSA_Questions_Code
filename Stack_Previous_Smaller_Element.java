import java.util.*;
public class Stack_Previous_Smaller_Element {
    public static int[] Smallestonleft(int arr[], int n) {
        Stack<Integer>st=new Stack<>();
        int result[]=new int [n];
        for(int i =0;i<n;i++){
            while(!st.isEmpty()&&st.peek()>=arr[i]){
                st.pop();
                
            }
            if(st.isEmpty()){
                result[i]=-1;
                
            }else{
                result[i]=st.peek();
                
            }
            st.push(arr[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int arr1[] = {2, 3, 4, 5, 1};
        int result1[] = Smallestonleft(arr1, arr1.length);
        System.out.println(Arrays.toString(result1)); // Output: [-1, 2, 3, 4, -1]

        int arr2[] = {1, 2, 3};
        int result2[] = Smallestonleft(arr2, arr2.length);
        System.out.println(Arrays.toString(result2)); // Output: [-1, 1, 2]

        int arr3[] = {3, 5, 4, 2, 2, 5, 5, 4, 2, 5};
        int result3[] = Smallestonleft(arr3, arr3.length);
        System.out.println(Arrays.toString(result3)); // Output: [-1, 3, 3, -1, -1, 4, 4, 3, -1, 4]
   
    }
}
