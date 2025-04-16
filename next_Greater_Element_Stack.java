import java.util.*;

public class next_Greater_Element_Stack {
    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        Stack<Integer> st = new Stack<>();
        int nxtGreater[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            // while loop
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            //// if else loop for checking the condition
            if (st.isEmpty()) {
                nxtGreater[i] = -1;

            } else {
                nxtGreater[i] = arr[st.peek()];
            }
            // push in stack
            st.push(i);

        }
        for (int i = 0; i < nxtGreater.length; i++) {
            System.out.print(nxtGreater[i] + "  ");
        }
        System.out.println();
    }
}
