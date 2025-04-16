import java.util.*;

public class maximum_Area_Histogram {
    public static void maxArea(int arr[]) {
        int maxArea = 0;
        int nextSmallerright[] = new int[arr.length];
        int nextSmallerleft[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        // next Smaller right
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();

            }
            if (st.isEmpty()) {
                nextSmallerright[i] = arr.length;// if(no one is smaller than that element then it returns to
                                                 // arr.length)

            } else {
                nextSmallerright[i] = st.peek();
            }
            st.push(i);
        }
        // next smaller left---
        st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextSmallerleft[i] = -1;
            } else {
                nextSmallerleft[i] = st.peek();
            }
            st.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nextSmallerright[i] - nextSmallerleft[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        System.out.println("MAXIMUM AREA IN HISTOGRAM : " + maxArea);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        maxArea(arr);
    }
}
