import java.util.Stack;
import java.util.*;
public class Stack_NumberOfGreater_Element_To_The_right {

    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        Stack<Integer> st = new Stack<>();
        int[] counter = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            counter[i] = st.size();
            st.push(arr[i]);
        }

        int[] result = new int[queries];
        for (int i = 0; i < queries; i++) {
            result[i] = counter[indices[i]];
        }
        return result;
    }
    public static void main(String[] args) {
        
    
    int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
    int[] indices = {0, 5};
    int[] result = count_NGEs(arr.length, arr, indices.length, indices);
    System.out.println(Arrays.toString(result));
}
}
    

