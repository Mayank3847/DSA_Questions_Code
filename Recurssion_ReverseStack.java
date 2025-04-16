import java.util.*;

public class Recurssion_ReverseStack {
    public static void reverseStack(Stack<Integer> st) {
       
    }

    public static void insertBottom(Stack<Integer> st, int num) {
        if (st.isEmpty()) {
            st.push(num);
            return;
        }
        int top = st.pop();
        insertBottom(st, num);
        st.push(top);

    }
    public static void main(String[] args) {
          Stack<Integer>st=new Stack<>();
          st.push(1);
          st.push(2);
          st.push(3);
          st.push(4);
          
          System.out.println("Original Stack: " + st);
          
          reverseStack(st);
          
          System.out.println("Reversed Stack: " + st);
    }
}
