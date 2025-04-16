//import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class stack_using_2_queue {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();

    }

    public void push(int data) {
        if (!q1.isEmpty()) {
            q1.add(data);
        } else {
            q2.add(data);
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("EMPTY QUEUE");
            return -1;
        }
        int top = -1;

        // CASE 1 ----WHERE QUEUE1 CONTAIN THE ELEMENT
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                top = q1.remove();
                if (q1.isEmpty()) {
                    break;
                }
                q2.add(top);
            }

        } else { // case 2 where ot contains element
            while (!q2.isEmpty()) {
                top = q2.remove();
                if (!q2.isEmpty()) {
                    break;
                }
                q1.add(top);
            }

        }
        return top;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("EMPTY STACK");
            return -1;
        }
        int top = -1;

        // case 1
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                top = q1.remove();
                q2.add(top);
            }

        } else {

            while (!q2.isEmpty()) {
                top = q2.remove();
                q1.add(top);

            }
        }
        return top;
    }

    public static void main(String[] args) {
        stack_using_2_queue st = new stack_using_2_queue();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        while (!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }

    }

}
