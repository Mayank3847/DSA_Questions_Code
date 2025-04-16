import java.util.*;

public class Stack_NextGreaterElement {
    public static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(nge, -1);
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <=   arr[i % n]) { 
                st.pop();
            }
            if (i < n) {
                if (!st.isEmpty()) {
                    nge[i % n] = st.peek();
                }
            }
            st.push(arr[i % n]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 10, 4, 2, 1, 2, 6 };
        int result[] = nextGreater(arr);
        System.out.println(Arrays.toString(result));

    }

}
