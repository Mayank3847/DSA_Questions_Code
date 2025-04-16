import java.util.*;

public class Stack_Asteroid_Collision {
    public static List<Integer> astroidCollision(int arr[]) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {    
            if (arr[i] > 0) {
                st.push(arr[i]);

            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(arr[i])) {
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() == Math.abs(arr[i])) {
                    st.pop();
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(arr[i]);
                }
            }
        }
        while (!st.isEmpty()) {
            result.add(0, st.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 10, -5 };
        List<Integer> result = astroidCollision(arr);
        System.out.println(result);

    }

}
